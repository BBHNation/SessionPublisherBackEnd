package com.hancock.SessionPublisher.intrastructure.utils;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TokenGenerator {
    public static String newUserToken(String userId) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        return Hashing.sha256().hashString(userId+now, StandardCharsets.UTF_8).toString();
    }
}
