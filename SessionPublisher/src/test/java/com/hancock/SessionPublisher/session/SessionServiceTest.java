package com.hancock.SessionPublisher.session;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SessionServiceTest {

    @Test
    public void shouldReturnAllSessions_whenCallAllSessionFunc_givenSessionService() {
        //given
        SessionService sessionService = new SessionService();

        //when
        List<SessionDomain> sessionDomains = sessionService.allSessions();

        //then
        Assert.assertNotNull(sessionDomains);
    }
}