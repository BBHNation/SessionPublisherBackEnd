package com.hancock.SessionPublisher.intrastructure.userToken;

import org.springframework.data.repository.Repository;

public interface UserTokenRepository extends Repository<UserTokenEntity, String> {
    public void save(UserTokenEntity entity);
    public UserTokenEntity findUserTokenEntityByUserId(String userId);
    public void deleteUserTokenEntityByContent(String token);
}
