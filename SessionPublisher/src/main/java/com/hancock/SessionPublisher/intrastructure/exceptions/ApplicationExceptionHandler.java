package com.hancock.SessionPublisher.intrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApplicationError handleArgumentNotValid(MethodArgumentNotValidException e) {
        return new ApplicationError(ExceptionCode.ARGUMENT_NOT_VALID, "APPLICATION ERROR, ARGUMENT NOT VALID");
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApplicationError handleNotReadable(HttpMessageNotReadableException e) {
        return new ApplicationError(ExceptionCode.Http_Message_Not_Readable, "REQUEST ERROR, REQUEST NOT READABLE");
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApplicationError handleNotReadable(MissingRequestHeaderException e) {
        return new ApplicationError(ExceptionCode.HTTP_HEADER_NOT_COMPLETE, "REQUEST ERROR, REQUEST HEADER NOT COMPLETE");
    }

}
