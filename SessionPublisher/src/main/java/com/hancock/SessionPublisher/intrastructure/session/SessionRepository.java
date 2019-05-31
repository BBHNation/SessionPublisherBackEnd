package com.hancock.SessionPublisher.intrastructure.session;

import com.hancock.SessionPublisher.session.SessionDomain;
import org.springframework.data.repository.Repository;

public interface SessionRepository extends Repository<SessionDomain, String> {
    public void save(SessionDomain domain);
    public SessionDomain findById(String id);
}
