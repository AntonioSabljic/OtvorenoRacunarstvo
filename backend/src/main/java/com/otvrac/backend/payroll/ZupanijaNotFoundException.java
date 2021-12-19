package com.otvrac.backend.payroll;

public class ZupanijaNotFoundException extends RuntimeException{
    public ZupanijaNotFoundException(String name) {
        super("Could not find zupanija " + name);
    }
}
