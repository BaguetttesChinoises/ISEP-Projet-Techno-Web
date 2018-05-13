package fr.isep.api.exception;

import fr.isep.api.exception.ApiException;

public class NotFoundException extends ApiException {
    private int code;

    public NotFoundException(int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
