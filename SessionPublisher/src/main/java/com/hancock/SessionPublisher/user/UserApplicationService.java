package com.hancock.SessionPublisher.user;

import com.hancock.SessionPublisher.intrastructure.exceptions.ConflictException;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionCode;
import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionSupplier;
import com.hancock.SessionPublisher.intrastructure.user.UserEntity;
import com.hancock.SessionPublisher.intrastructure.user.UserRepository;
import com.hancock.SessionPublisher.intrastructure.userToken.UserTokenEntity;
import com.hancock.SessionPublisher.intrastructure.userToken.UserTokenRepository;
import com.hancock.SessionPublisher.intrastructure.utils.TokenGenerator;
import com.hancock.SessionPublisher.user.views.LoginRequest;
import com.hancock.SessionPublisher.user.views.LogoutRequest;
import com.hancock.SessionPublisher.user.views.RegisterRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserApplicationService {
    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;

    public UserApplicationService(
        UserRepository repository,
        UserTokenRepository userTokenRepository) {
        this.userRepository = repository;
        this.userTokenRepository = userTokenRepository;
    }

    public void registerUser(RegisterRequest request) {
        try {
            UserDomain domain = new UserDomain(request.getEmail(), request.getName(), request.getSecurityCode());
            userRepository.save(new UserEntity(domain));
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new ConflictException(ExceptionCode.USER_DATA_CONFLICT);
            } else {
                throw e;
            }
        }
    }

    public String login(LoginRequest request) {
        try {
            UserEntity userEntity = userRepository.findUserEntityByEmail(request.getEmail())
                .orElseThrow(ExceptionSupplier.userNotFound());
            UserDomain userDomain = userEntity.mapToDomain();
            if (userDomain.getSecurityCode().equals(request.getSecurityCode())) {
                return updateLoginStateAndGeneratorToken(userDomain);
            } else {
                throw new ConflictException(ExceptionCode.SECURITY_CODE_WRONG);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Transactional
    String updateLoginStateAndGeneratorToken(UserDomain userDomain) {
        userRepository.save(new UserEntity(userDomain.goOnLine()));
        String newToken = TokenGenerator.newUserToken(userDomain.getId());
        UserTokenEntity userTokenEntity = new UserTokenEntity(userDomain.getId(), newToken,
            Timestamp.valueOf(LocalDateTime.now()));
        userTokenRepository.save(userTokenEntity);
        return newToken;
    }

    @Transactional
    public void logout(LogoutRequest request, String token) {
        UserEntity userEntityByEmail = userRepository
            .findUserEntityByEmail(request.getEmail()).orElseThrow(ExceptionSupplier.userNotFound());
        userRepository.save(new UserEntity(userEntityByEmail.mapToDomain().goOffline()));
        userTokenRepository.deleteUserTokenEntityByContent(token);
    }
}
