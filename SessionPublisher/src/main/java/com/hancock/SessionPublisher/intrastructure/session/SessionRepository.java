package com.hancock.SessionPublisher.intrastructure.session;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface SessionRepository extends Repository<SessionEntity, String> {
    public void save(SessionEntity entity);
    public SessionEntity findById(String id);
    public List<SessionEntity> findAll();
}
