package com.hancock.SessionPublisher.user.views;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String securityCode;
    @NotBlank
    private String name;
}
