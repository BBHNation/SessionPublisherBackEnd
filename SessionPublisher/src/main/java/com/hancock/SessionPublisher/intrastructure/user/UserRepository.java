package com.hancock.SessionPublisher.intrastructure.user;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, String> {
    public void save(UserEntity entity);
    public Optional<UserEntity> getUserEntityByEmail(String email);
    public Optional<UserEntity> getUserEntityById(String userId);
}
