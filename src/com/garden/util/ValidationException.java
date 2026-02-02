package com.garden.util;

public class ValidationException extends Exception {
    public String toString() {
        return "Validation failed. Please check your input.";
    }
}
