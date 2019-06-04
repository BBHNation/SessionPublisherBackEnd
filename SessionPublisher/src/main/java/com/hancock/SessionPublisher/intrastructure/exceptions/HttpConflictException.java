package com.hancock.SessionPublisher.intrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "数据冲突")
public class HttpConflictException extends RuntimeException {
}
