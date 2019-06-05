package com.hancock.SessionPublisher.intrastructure.exceptions;

import java.util.function.Supplier;

public class ExceptionSupplier {
    public static Supplier<NotFoundException> userNotFound() {
        return ()->new NotFoundException(ExceptionCode.USER_NOT_FOUND);
    }
}
