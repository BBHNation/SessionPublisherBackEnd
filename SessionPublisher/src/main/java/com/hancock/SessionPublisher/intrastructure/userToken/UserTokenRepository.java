package com.hancock.SessionPublisher.intrastructure.userToken;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface UserTokenRepository extends Repository<UserTokenEntity, String> {
    public void save(UserTokenEntity entity);
    public Optional<UserTokenEntity> findUserTokenEntityByUserId(String userId);
    public void deleteUserTokenEntityByContent(String token);
}
