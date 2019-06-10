package com.hancock.SessionPublisher.user.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class LogoutRequest {
    private String email;
}
