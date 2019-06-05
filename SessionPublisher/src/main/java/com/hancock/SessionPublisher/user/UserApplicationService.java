package com.hancock.SessionPublisher.user;

import com.hancock.SessionPublisher.intrastructure.exceptions.ConflictException;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionCode;
import com.hancock.SessionPublisher.intrastructure.user.UserEntity;
import com.hancock.SessionPublisher.intrastructure.user.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    private final UserRepository repository;

    public UserApplicationService(
        UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(UserDomain domain) {
        try {
            repository.save(new UserEntity(domain));
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new ConflictException(ExceptionCode.USER_DATA_CONFLICT);
            } else {
                throw e;
            }
        }
    }
}
