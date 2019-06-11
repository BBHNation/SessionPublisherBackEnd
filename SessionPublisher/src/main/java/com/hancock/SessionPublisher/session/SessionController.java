package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.intrastructure.utils.UserTokenChecker;
import com.hancock.SessionPublisher.session.views.CreateSessionRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
    private final SessionApplicationService applicationService;
    private final UserTokenChecker userTokenChecker;

    @Autowired
    public SessionController(SessionApplicationService applicationService,
        UserTokenChecker userTokenChecker) {
        this.applicationService = applicationService;
        this.userTokenChecker = userTokenChecker;
    }

    @GetMapping(value = "/list")
    public List<SessionDomain> sessionDomainList(@RequestHeader("token") String token, @RequestHeader("email") String email) {
        userTokenChecker.checkUserTokenValid(email, token);
        return applicationService.getSessionDomainList();
    }

    @GetMapping(value = "/detail/{sessionId}")
    public SessionDomain sessionInfo(@PathVariable String sessionId, @RequestHeader("token") String token, @RequestHeader("email") String email) {
        userTokenChecker.checkUserTokenValid(email, token);
        return applicationService.findSessionById(sessionId);
    }

    @PutMapping(value = "")
    public void createSession(@RequestBody @Validated CreateSessionRequest request, @RequestHeader("token") String token, @RequestHeader("email") String email) {
        userTokenChecker.checkUserTokenValid(email, token);
        applicationService.createSession(request, email);
    }

    @PostMapping(value = "/{sessionId}/nextStage")
    public void gotoNextStage(@PathVariable String sessionId, @RequestHeader("token") String token, @RequestHeader("email") String email) {
        userTokenChecker.checkUserTokenValid(email, token);
        applicationService.sessionGotoNextStage(sessionId);
    }

    @PostMapping(value = "/{sessionId}/publish")
    public void publishSession(@PathVariable String sessionId, @RequestHeader("token") String token, @RequestHeader("email") String email) {
        userTokenChecker.checkUserTokenValid(email, token);
        applicationService.publishSession(sessionId);
    }

}
