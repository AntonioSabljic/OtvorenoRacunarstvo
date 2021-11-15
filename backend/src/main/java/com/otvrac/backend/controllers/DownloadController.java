package com.otvrac.backend.controllers;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.exporter.JsonExporterService;
import com.otvrac.backend.services.GradService;
import com.otvrac.backend.services.ZupanijaService;
import com.otvrac.backend.services.Zupanija_susjedne_zupanijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DownloadController {

    private JsonExporterService jsonExporter;
    private ZupanijaService zupanijaService;
    private GradService gradService;
    private Zupanija_susjedne_zupanijeService zupanija_susjedne_zupanijeService;


    @Autowired
    public DownloadController(JsonExporterService jsonExporter, ZupanijaService zupanijaService, GradService gradService, Zupanija_susjedne_zupanijeService zupanija_susjedne_zupanijeService) {
        this.jsonExporter = jsonExporter;
        this.zupanijaService = zupanijaService;
        this.gradService = gradService;
        this.zupanija_susjedne_zupanijeService = zupanija_susjedne_zupanijeService;
    }

    @GetMapping("/downloadJsonZupanije")
    public ResponseEntity<byte[]> downloadJsonFile(Model model) {
        List<Zupanija> zupanije = zupanijaService.getAllZupanija();

        String zupanijeJsonString = jsonExporter.export(zupanije);

        byte[] zupanijeJsonBytes = zupanijeJsonString.getBytes();

        return (ResponseEntity<byte[]>) ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=zupanije.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(zupanijeJsonBytes.length)
                .body(zupanijeJsonBytes);
    }
}
