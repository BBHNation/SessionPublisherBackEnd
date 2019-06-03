package com.hancock.SessionPublisher.session;

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

    public SessionDomain findSessionById(String id) {
//        return new SessionDomain("title", "subTitle", 1, 3).bindPublishStatus(true);
        try {
            return sessionRepository.findById(id).mapToDomain();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
