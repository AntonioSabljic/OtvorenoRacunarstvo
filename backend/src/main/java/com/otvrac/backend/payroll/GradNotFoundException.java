package com.otvrac.backend.payroll;

public class GradNotFoundException extends RuntimeException{
    public GradNotFoundException(String name) {
        super("Could not find grad " + name);
    }
}
