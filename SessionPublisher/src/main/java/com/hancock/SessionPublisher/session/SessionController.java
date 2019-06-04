package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.session.views.CreateSessionRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
    private final SessionApplicationService applicationService;

    @Autowired
    public SessionController(SessionApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(value = "/list")
    public List<SessionDomain> sessionDomainList() {
        return applicationService.getSessionDomainList();
    }

    @GetMapping(value = "/detail/{sessionId}")
    public SessionDomain sessionInfo(@PathVariable String sessionId) {
        return applicationService.findSessionById(sessionId);
    }

    @PutMapping(value = "")
    public void createSession(@RequestBody @Validated CreateSessionRequest request) {
        applicationService.createSession(request);
    }

    @PostMapping(value = "/{sessionId}/nextStage")
    public void gotoNextStage(@PathVariable String sessionId) {
        applicationService.sessionGotoNextStage(sessionId);
    }

    @PostMapping(value = "/{sessionId}/publish")
    public void publishSession(@PathVariable String sessionId) {
        applicationService.publishSession(sessionId);
    }

}
