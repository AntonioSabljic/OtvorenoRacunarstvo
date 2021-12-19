package com.otvrac.backend.controllers;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.payroll.GradNotFoundException;
import com.otvrac.backend.payroll.GradoviNotFoundException;
import com.otvrac.backend.payroll.ZupanijaNotFoundException;
import com.otvrac.backend.payroll.ZupanijeNotFoundException;
import com.otvrac.backend.services.GradService;
import com.otvrac.backend.services.ZupanijaService;
import com.otvrac.backend.services.Zupanija_susjedne_zupanijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
public class ZupanijaController {

    private final ZupanijaService zupanijaService;
    private final GradService gradService;
    private final Zupanija_susjedne_zupanijeService zupanija_susjedne_zupanijeService;
    @Autowired
    public ZupanijaController(ZupanijaService zupanijaService, GradService gradService, Zupanija_susjedne_zupanijeService zupanija_susjedne_zupanijeService) {
        this.zupanijaService = zupanijaService;
        this.gradService = gradService;
        this.zupanija_susjedne_zupanijeService = zupanija_susjedne_zupanijeService;
    }


    @GetMapping ("/")
    public String getIndex(Model model) {
        model.addAttribute("zupanije", zupanijaService.getAllZupanija());
        return "index";
    }
    @ResponseBody
    @GetMapping ("/zupanije")
    public CollectionModel<EntityModel<Zupanija>> getZupanije() {
        List<Zupanija> zupanije = zupanijaService.getAllZupanija();
        if(zupanije == null) {
            throw new ZupanijeNotFoundException();
        }
        List<EntityModel<Zupanija>> zaReturn = zupanije.stream()
                .map(zupanija -> EntityModel.of(zupanija,
                        linkTo(methodOn(ZupanijaController.class).getZupanija(zupanija.getNaziv())).withSelfRel(),
                        linkTo(methodOn(ZupanijaController.class).getZupanije()).withRel("zupanije")))
                .collect(Collectors.toList());

        return CollectionModel.of(zaReturn, linkTo(methodOn(ZupanijaController.class).getZupanije()).withSelfRel());
    }
    @ResponseBody
    @GetMapping("/zupanije/{name}")
    public EntityModel<Zupanija> getZupanija(@PathVariable String name) {
        Zupanija z = zupanijaService.getZupanijaByName(name.substring(1,name.length()-1));

        if(z == null) {
            throw new ZupanijaNotFoundException(name.substring(1,name.length()-1));
        }

        return EntityModel.of(z,
                linkTo(methodOn(ZupanijaController.class).getZupanija(name)).withSelfRel(),
                linkTo(methodOn(ZupanijaController.class).getZupanije()).withRel("zupanije"));
    }
    @ResponseBody
    @GetMapping("/gradovi")
    public CollectionModel<EntityModel<Grad>> getGradovi() {
        List<Grad> g = gradService.getAllGrad();
        if(g == null) {
            throw new GradoviNotFoundException();
        }
        List<EntityModel<Grad>> zaReturn = g.stream()
                .map(grad -> EntityModel.of(grad,
                        linkTo(methodOn(ZupanijaController.class).getGrad(grad.getNazivG())).withRel("gradovi"),
                        linkTo(methodOn(ZupanijaController.class).getGradovi()).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(zaReturn, linkTo(methodOn(ZupanijaController.class).getGradovi()).withSelfRel());
    }

    @ResponseBody
    @GetMapping("/gradovi/{name}")
    public EntityModel<Grad> getGrad(@PathVariable String name) {
        Grad g = gradService.getGradByName(name.substring(1,name.length()-1));

        if(g == null) {
            throw new GradNotFoundException(name);
        }

        return EntityModel.of(g,
                linkTo(methodOn(ZupanijaController.class).getGrad(name)).withSelfRel(),
                linkTo(methodOn(ZupanijaController.class).getGradovi()).withRel("gradovi"));
    }

    @ResponseBody
    @GetMapping("/zupanije/{name}/gradovi")
    public CollectionModel<EntityModel<Grad>> getGradoviForZupanija(@PathVariable String name) {
        List<Grad> g = gradService.getAllGradForZupanija(name.substring(1,name.length()-1));

        if(g == null) {
            throw new ZupanijaNotFoundException(name.substring(1,name.length()-1));
        }

        List<EntityModel<Grad>> zaReturn = g.stream()
                .map(grad -> EntityModel.of(grad,
                        linkTo(methodOn(ZupanijaController.class).getGradoviForZupanija(grad.getNazivG())).withSelfRel(),
                        linkTo(methodOn(ZupanijaController.class).getGradovi()).withRel("gradovi")))
                .collect(Collectors.toList());

        return CollectionModel.of(zaReturn, linkTo(methodOn(ZupanijaController.class).getGradoviForZupanija(name)).withSelfRel());
    }
    @PostMapping("/gradovi")
    @ResponseBody
    ResponseEntity<?> newGrad(@RequestBody Grad noviGrad) {
        EntityModel<Grad> entityModel = EntityModel.of(noviGrad);
        boolean flag = gradService.addGrad(noviGrad);
        if(flag == false) {
                   System.out.println("Nije se upisalo.");
        }
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel); //ovdje puca
    }

    @DeleteMapping("/gradovi/{name}")
    @ResponseBody
    ResponseEntity<?> deleteGrad(@PathVariable String name) {
        gradService.removeGrad(name.substring(1,name.length()-1));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/gradovi/{name}")
    @ResponseBody
    EntityModel<Grad> replaceGrad(@RequestBody Grad newGrad, @PathVariable String name) {
        Grad grad = gradService.getGradByName(name.substring(1,name.length()-1));
        if(grad == null) {
            gradService.addGrad(newGrad);
            return EntityModel.of(newGrad,
                    linkTo(methodOn(ZupanijaController.class).getGradoviForZupanija(newGrad.getNazivG())).withSelfRel(),
                    linkTo(methodOn(ZupanijaController.class).getGradovi()).withRel("gradovi"));
        }
        gradService.updateGradByName(newGrad, name.substring(1,name.length()-1));

        return EntityModel.of(newGrad,
                linkTo(methodOn(ZupanijaController.class).getGradoviForZupanija(grad.getNazivG())).withSelfRel(),
                linkTo(methodOn(ZupanijaController.class).getGradovi()).withRel("gradovi"));
    }



    @GetMapping("/info")
    public String getInfo(Model model, @RequestParam String zupanija) {
        model.addAttribute("gradovi", gradService.getAllGradForZupanija(zupanija));
        model.addAttribute("susZupanije", zupanija_susjedne_zupanijeService.getAllZupanijaSusZupanijeByZupanijaName(zupanija));
        return "info";
    }
    //path za openapi /api-docs
    //swagger path /swagger-ui.html
}
