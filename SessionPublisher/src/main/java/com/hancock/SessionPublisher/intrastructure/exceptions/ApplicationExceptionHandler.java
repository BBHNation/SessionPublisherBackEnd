package com.hancock.SessionPublisher.intrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApplicationError handleNotFoundException(NotFoundException e) {
        return new ApplicationError(e.getCode(), "APPLICATION ERROR, RESOURCE NOT FOUND");
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ResponseBody
    public ApplicationError handleConflictException(ConflictException e) {
        return new ApplicationError(e.getCode(), "APPLICATION ERROR, RESOURCE CONFLICT");
    }

}
