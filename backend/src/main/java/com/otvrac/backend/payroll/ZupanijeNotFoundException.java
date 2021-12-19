package com.otvrac.backend.payroll;

public class ZupanijeNotFoundException extends RuntimeException{
    public ZupanijeNotFoundException() {
        super("Could not find zupanije");
    }
}
