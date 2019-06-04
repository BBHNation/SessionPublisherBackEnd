package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.intrastructure.session.SessionEntity;
import com.hancock.SessionPublisher.intrastructure.session.SessionRepository;
import com.hancock.SessionPublisher.session.views.CreateSessionRequest;
import java.util.List;
import java.util.stream.Collectors;
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
        return sessionRepository.findById(sessionId).mapToDomain();
    }

    public void createSession(CreateSessionRequest request) {
        SessionDomain sessionDomain = new SessionDomain(
                request.getTitle(),
                request.getSubTitle(),
                request.getCurrentStage(),
                request.getTotalStage());
        sessionRepository.save(new SessionEntity(sessionDomain));
    }

    public void sessionGotoNextStage(String sessionId) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionId);
        sessionRepository.save(new SessionEntity(sessionEntity.mapToDomain().gotoNextStage()));
    }

    public void publishSession(String sessionId) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionId);
        sessionRepository.save(new SessionEntity(sessionEntity.mapToDomain().publish()));
    }

    public List<SessionDomain> getSessionDomainList() {
        return sessionRepository.findAll().stream().map(SessionEntity::mapToDomain).collect(Collectors.toList());
    }

}
