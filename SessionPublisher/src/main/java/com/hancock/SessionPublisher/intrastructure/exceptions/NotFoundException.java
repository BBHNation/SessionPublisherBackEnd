package com.hancock.SessionPublisher.intrastructure.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private ExceptionCode code;

    public NotFoundException(ExceptionCode code) {
        this.code = code;
    }
}
