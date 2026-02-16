/*
 * Property of Le - Creator of Puribot AI
 * Copyright (c) 2026. All rights reserved.
 * * This code is part of the Puribot-AI-Core project.
 * Unauthorized copying, modification, or distribution is strictly prohibited.
 * Purpose: Detecting ethical infractions and protecting neurodivergent individuals.
 * Contact: [leticiaferreira150998@gmail.com]
 */
package com.puribot.ai_core.infrastructure.security;

import java.security.MessageDigest;
import java.util.Base64;

public class SecurityShield {
    public static String generateEvidenceHash(String content) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(content.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }
}

