package com.SpringTdd.services.exceptions;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException() {
        super("Duplicate email, this e-mail already exists!");
    }

    public DuplicateEmailException(String errorMessage) {
        super(errorMessage);
    }
}
