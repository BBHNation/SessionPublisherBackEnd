package com.hancock.SessionPublisher.intrastructure.utils;

import com.hancock.SessionPublisher.intrastructure.exceptions.ExceptionSupplier;
import com.hancock.SessionPublisher.intrastructure.user.UserRepository;
import com.hancock.SessionPublisher.intrastructure.userToken.UserTokenEntity;
import com.hancock.SessionPublisher.intrastructure.userToken.UserTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTokenChecker {
    private final UserTokenRepository userTokenRepository;
    private final UserRepository userRepository;

    public UserTokenChecker(
        UserTokenRepository userTokenRepository,
        UserRepository userRepository) {
        this.userTokenRepository = userTokenRepository;
        this.userRepository = userRepository;
    }

    public void checkUserTokenValid(String email, String token) {
        String userId = userRepository.findUserEntityByEmail(email)
            .orElseThrow(ExceptionSupplier.userNotFound()).getId();
        UserTokenEntity userTokenEntity = userTokenRepository
            .findUserTokenEntityByUserId(userId).orElseThrow(ExceptionSupplier.tokenNotValid());
        if (!userTokenEntity.getContent().equals(token)) {
            throw ExceptionSupplier.tokenNotValid().get();
        }
    }
}
