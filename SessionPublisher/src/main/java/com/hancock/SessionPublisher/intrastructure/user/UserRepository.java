package com.hancock.SessionPublisher.intrastructure.user;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, String> {
    public void save(UserEntity entity);
    public void getUserEntityByEmail(String email);
}
