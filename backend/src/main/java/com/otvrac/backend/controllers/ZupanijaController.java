package com.otvrac.backend.controllers;

import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.services.GradService;
import com.otvrac.backend.services.ZupanijaService;
import com.otvrac.backend.services.Zupanija_susjedne_zupanijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ZupanijaController {

    private final ZupanijaService zupanijaService;
    private final GradService gradService;
    private final Zupanija_susjedne_zupanijeService zupanija_susjedne_zupanijeService;
    //treba ovo popravit sa autowired
    @Autowired
    public ZupanijaController(ZupanijaService zupanijaService, GradService gradService, Zupanija_susjedne_zupanijeService zupanija_susjedne_zupanijeService) {
        this.zupanijaService = zupanijaService;
        this.gradService = gradService;
        this.zupanija_susjedne_zupanijeService = zupanija_susjedne_zupanijeService;
    }
    /*
    @Autowired
    public ZupanijaController(ZupanijaService zupanijaService) {
        this.zupanijaService = zupanijaService;
        this.gradService = null;
        this. zupanija_susjedne_zupanijeService = null;
    }*/



    @GetMapping ("/")
    public String getZupanije(Model model) {
        model.addAttribute("zupanije", zupanijaService.getAllZupanija());
        return "index";
    }

    @GetMapping("/info")
    public String getInfo(Model model, @RequestParam String zupanija) {
        model.addAttribute("gradovi", gradService.getAllGradForZupanija(zupanija));
        model.addAttribute("susZupanije", zupanija_susjedne_zupanijeService.getAllZupanijaSusZupanijeByZupanijaName(zupanija));
        return "info";
    }

}
