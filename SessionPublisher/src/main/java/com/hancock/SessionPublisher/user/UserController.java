package com.hancock.SessionPublisher.user;

import com.hancock.SessionPublisher.user.views.LoginRequest;
import com.hancock.SessionPublisher.user.views.LogoutRequest;
import com.hancock.SessionPublisher.user.views.RegisterRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @PostMapping(value = "/login")
    public ResponseEntity<Void> loginUser(@RequestBody @Validated LoginRequest request) {
        String token = applicationService.login(request);
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public void logoutUser(@RequestBody @Validated LogoutRequest request, @RequestHeader("token") String token) {
        applicationService.logout(request, token);
    }
}
