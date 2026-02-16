package com.puribot.ai_core.security;

import java.security.MessageDigest;
import java.util.Base64;

public class SecurityShield {
    public static String generateEvidenceHash(String content) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(content.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }
}

