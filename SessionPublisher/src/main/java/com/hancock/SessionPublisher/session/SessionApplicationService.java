package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionCode;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionSupplier;
import com.hancock.SessionPublisher.intrastructure.exceptions.ConflictException;
import com.hancock.SessionPublisher.intrastructure.exceptions.NotFoundException;
import com.hancock.SessionPublisher.intrastructure.session.SessionEntity;
import com.hancock.SessionPublisher.intrastructure.session.SessionRepository;
import com.hancock.SessionPublisher.intrastructure.user.UserRepository;
import com.hancock.SessionPublisher.session.views.CreateSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionApplicationService {

    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    @Autowired
    public SessionApplicationService(SessionRepository sessionRepository,
        UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public SessionDomain findSessionById(String sessionId) {
        return sessionRepository.findById(sessionId)
            .orElseThrow(ExceptionSupplier.sessionNotFound())
            .mapToDomain();
    }

    public void createSession(CreateSessionRequest request) {
        checkUserExist(request.getCreatorId());
        SessionDomain sessionDomain = new SessionDomain(
            request.getTitle(),
            request.getSubTitle(),
            request.getCurrentStage(),
            request.getTotalStage(),
            request.getCreatorId());
        try {
            sessionRepository.save(new SessionEntity(sessionDomain));
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new ConflictException(ExceptionCode.SESSION_DATA_CONFLICT);
            } else {
                throw e;
            }
        }
    }

    public void sessionGotoNextStage(String sessionId) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(ExceptionSupplier.sessionNotFound());
        sessionRepository.save(new SessionEntity(sessionEntity.mapToDomain().gotoNextStage()));
    }

    public void publishSession(String sessionId) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(ExceptionSupplier.sessionNotFound());
        sessionRepository.save(new SessionEntity(sessionEntity.mapToDomain().publish()));
    }

    public List<SessionDomain> getSessionDomainList() {
        return sessionRepository.findAll().stream().map(SessionEntity::mapToDomain)
            .collect(Collectors.toList());
    }

    public void checkUserExist(String userId) throws NotFoundException {
        userRepository.findUserEntityById(userId)
            .orElseThrow(ExceptionSupplier.userNotFound());
    }
}
