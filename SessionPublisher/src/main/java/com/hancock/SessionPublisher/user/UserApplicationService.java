package com.hancock.SessionPublisher.user;

import com.hancock.SessionPublisher.intrastructure.exceptions.ConflictException;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionCode;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionSupplier;
import com.hancock.SessionPublisher.intrastructure.user.UserEntity;
import com.hancock.SessionPublisher.intrastructure.user.UserRepository;
import com.hancock.SessionPublisher.user.views.LoginRequest;
import com.hancock.SessionPublisher.user.views.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserApplicationService {
    private final UserRepository repository;

    public UserApplicationService(
        UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(RegisterRequest request) {
        try {
            UserDomain domain = new UserDomain(request.getEmail(), request.getName(), request.getSecurityCode());
            repository.save(new UserEntity(domain));
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new ConflictException(ExceptionCode.USER_DATA_CONFLICT);
            } else {
                throw e;
            }
        }
    }

    public void login(LoginRequest request) {
        try {
            UserEntity userEntity = repository.getUserEntityByEmail(request.getEmail())
                .orElseThrow(ExceptionSupplier.userNotFound());
            UserDomain userDomain = userEntity.mapToDomain();
            if (userDomain.getSecurityCode().equals(request.getSecurityCode())) {
                repository.save(new UserEntity(userDomain.goOnLine()));
            } else {
                throw new ConflictException(ExceptionCode.SECURITY_CODE_WRONG);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

}
