package com.hancock.SessionPublisher.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
    private final SessionApplicationService applicationService;

    @Autowired
    public SessionController(SessionApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/detail/{sessionId}")
    public SessionDomain sessionInfo(@PathVariable String sessionId) {
        return applicationService.findSessionById(sessionId);
    }

    @PutMapping(value = "")
    public void createSession(@RequestBody SessionDomain domain) {
        applicationService.saveSession(domain);
    }

    @PostMapping(value = "/{sessionId}/nextStage")
    public void gotoNextStage(@PathVariable String sessionId) {
        applicationService.sessionGotoNextStage(sessionId);
    }

}
