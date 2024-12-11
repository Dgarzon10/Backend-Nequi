package com.franquicias.api.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    // Getters and Setters
    private String message;

    // Constructor
    public ErrorResponse(String message) {
        this.message = message;
    }

}
