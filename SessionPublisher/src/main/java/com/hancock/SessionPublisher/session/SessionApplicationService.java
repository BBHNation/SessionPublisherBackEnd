package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.intrastructure.session.SessionEntity;
import com.hancock.SessionPublisher.intrastructure.session.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionApplicationService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionApplicationService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public SessionDomain findSessionById(String sessionId) {
//        return new SessionDomain("title", "subTitle", 1, 3).bindPublishStatus(true);
        return sessionRepository.findById(sessionId).mapToDomain();
    }

    public String saveSession(SessionDomain domain) {
        sessionRepository.save(new SessionEntity(domain));
        return "ok";
    }

}
