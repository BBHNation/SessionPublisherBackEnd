package com.hancock.SessionPublisher.intrastructure.user;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, String> {
    public void save(UserEntity entity);
    public Optional<UserEntity> findUserEntityByEmail(String email);
    public Optional<UserEntity> findUserEntityById(String userId);
}
