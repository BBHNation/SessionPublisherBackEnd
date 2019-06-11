package com.hancock.SessionPublisher.intrastructure.userToken;

import com.hancock.SessionPublisher.SpringTestBase;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionSupplier;
import java.sql.Timestamp;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTokenRepositoryTest extends SpringTestBase {
    @Autowired
    private UserTokenRepository repository;

    @Test
    public void shouldRepositoryFindEntityRight_whenSavedTokenInDataBase_givenUserTokenEntity() {
        UserTokenEntity userTokenEntity = new UserTokenEntity("user id", "content",
            new Timestamp(1000000000));
        repository.save(userTokenEntity);
        UserTokenEntity entityFromDataBase = repository.findUserTokenEntityByUserId("user id")
            .orElseThrow(ExceptionSupplier.tokenNotValid());
        Assert.assertEquals("content", entityFromDataBase.getContent());
    }
}