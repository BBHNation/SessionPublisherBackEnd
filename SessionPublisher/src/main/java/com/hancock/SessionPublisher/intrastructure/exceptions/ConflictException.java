package com.hancock.SessionPublisher.intrastructure.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class ConflictException extends RuntimeException {
    private ExceptionCode code;

    public ConflictException(ExceptionCode code) {
        this.code = code;
    }
}
