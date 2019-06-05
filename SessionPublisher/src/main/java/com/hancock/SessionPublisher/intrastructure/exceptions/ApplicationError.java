package com.hancock.SessionPublisher.intrastructure.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

@Getter
public class ApplicationError {

    private int code;
    private String message;

    public ApplicationError(ExceptionCode exceptionCode, String message) {
        this.code = exceptionCode.getCode();
        this.message = message + ": " + exceptionCode.name();
    }

    @Default
    @JsonInclude(Include.NON_NULL)
    private List<Error> details;

    @Builder
    @Getter
    public static class Error {

        private String field;
        private String message;
    }
}
