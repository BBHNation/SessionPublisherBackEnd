package com.hancock.SessionPublisher.user.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String securityCode;
}
