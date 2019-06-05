package com.hancock.SessionPublisher.intrastructure.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    USER_NOT_FOUND(404001),
    SESSION_DATA_CONFLICT(409001),
    USER_DATA_CONFLICT(409002);

    private int code;

    private ExceptionCode(int code) {
        this.code = code;
    }
}