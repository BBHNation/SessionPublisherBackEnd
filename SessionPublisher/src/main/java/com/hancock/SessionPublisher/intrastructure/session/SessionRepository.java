package com.hancock.SessionPublisher.intrastructure.session;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface SessionRepository extends Repository<SessionEntity, String> {
    public void save(SessionEntity entity);
    public Optional<SessionEntity> findById(String id);
    public List<SessionEntity> findAll();
}
