package com.hancock.SessionPublisher.session.views;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class CreateSessionRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String subTitle;

    private int currentStage;

    private int totalStage;
}
