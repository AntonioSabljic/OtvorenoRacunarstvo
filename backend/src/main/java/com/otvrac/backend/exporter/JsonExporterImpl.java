package com.otvrac.backend.exporter;

import com.google.gson.Gson;
import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.domain.Zupanija_susjedne_zupanije;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JsonExporterImpl implements JsonExporterService{


    @Override
    public String export(List<Zupanija> zupanijaList) {
        Gson gson = new Gson();
        String zupanijaInJson = gson.toJson(zupanijaList);
        return zupanijaInJson;
    }
}
