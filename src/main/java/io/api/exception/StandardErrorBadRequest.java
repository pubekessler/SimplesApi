package io.api.exception;

import java.io.Serializable;

import lombok.Getter;

public class StandardErrorBadRequest implements Serializable {
    private static final long serialVersionUID = 1L;

  
    @Getter private String status_code="400";
    @Getter private String message = "";

    public StandardErrorBadRequest(String message) {
        this.message = message;
    }
}
