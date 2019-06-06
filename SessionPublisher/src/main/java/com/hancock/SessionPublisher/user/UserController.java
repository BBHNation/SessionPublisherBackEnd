package com.hancock.SessionPublisher.user;

import com.hancock.SessionPublisher.user.views.RegisterRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserApplicationService applicationService;

    public UserController(
        UserApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PutMapping(value = "")
    public void registerUser(@RequestBody @Validated RegisterRequest request) {
        applicationService.registerUser(request);
    }
}
