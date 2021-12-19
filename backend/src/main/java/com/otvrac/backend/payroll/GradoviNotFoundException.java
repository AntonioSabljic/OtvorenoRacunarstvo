package com.otvrac.backend.payroll;

public class GradoviNotFoundException extends RuntimeException{
    public GradoviNotFoundException() {
        super("Could not find gradovi");
    }
}
