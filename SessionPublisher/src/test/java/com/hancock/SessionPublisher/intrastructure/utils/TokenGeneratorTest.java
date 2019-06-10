package com.hancock.SessionPublisher.intrastructure.utils;

import org.junit.Assert;
import org.junit.Test;

public class TokenGeneratorTest {

    @Test
    public void tokenShouldNotBeNull_whenGeneratNewToken_givenUserIdAndTime() {
        //given
        String token = TokenGenerator
            .newUserToken("userId");
        System.out.println(token);
        //then
        Assert.assertNotNull(token);
    }
}