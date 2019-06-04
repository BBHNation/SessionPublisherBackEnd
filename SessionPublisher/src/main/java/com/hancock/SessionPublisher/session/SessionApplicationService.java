package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.intrastructure.exceptions.HttpConflictException;
import com.hancock.SessionPublisher.intrastructure.session.SessionEntity;
import com.hancock.SessionPublisher.intrastructure.session.SessionRepository;
import com.hancock.SessionPublisher.session.views.CreateSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.net.HttpURLConnection;

import java.util.List;
import java.util.stream.Collectors;

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
        try {
            sessionRepository.save(new SessionEntity(sessionDomain));
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new HttpConflictException();
            } else {
                throw e;
            }
        }
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
