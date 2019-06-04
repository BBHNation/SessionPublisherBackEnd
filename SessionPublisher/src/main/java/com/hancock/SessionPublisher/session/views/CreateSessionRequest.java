package com.hancock.SessionPublisher.session.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Validated
@AllArgsConstructor
public class CreateSessionRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String subTitle;

    private int currentStage;

    private int totalStage;
}
