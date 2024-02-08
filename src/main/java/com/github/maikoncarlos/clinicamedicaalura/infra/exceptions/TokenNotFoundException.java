package com.github.maikoncarlos.clinicamedicaalura.infra.exceptions;

public class TokenNotFoundException extends NullPointerException {
    public TokenNotFoundException(String msg) {
        super(msg);
    }
}
