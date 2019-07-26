package com.hancock.SessionPublisher.intrastructure.user;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, String> {
    void save(UserEntity entity);
    Optional<UserEntity> findUserEntityByEmail(String email);
    Optional<UserEntity> findUserEntityById(String userId);
    Optional<UserEntity> findUserEntityByName(String name);
}
