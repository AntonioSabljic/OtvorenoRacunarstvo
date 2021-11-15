package com.otvrac.backend.exporter;

import com.otvrac.backend.domain.Grad;
import com.otvrac.backend.domain.Zupanija;
import com.otvrac.backend.domain.Zupanija_susjedne_zupanije;

import java.util.List;

public interface JsonExporterService {
    String export(List<Zupanija> zupanijaList);
}
