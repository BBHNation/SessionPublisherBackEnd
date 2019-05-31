package com.hancock.SessionPublisher.session;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public List<SessionDomain> allSessions() {
        return new ArrayList<>();
    }

}
