package com.empikproject.domain.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private final ErrorCode code;
    private final String message;

    public ApiException(ErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
