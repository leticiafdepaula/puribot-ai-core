package com.puribot.ai_core.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CryptoUtils {
    private static final String ALGORITHM = "AES";

    public static String encrypt(String value, String key) throws Exception {

        byte[] keyBytes = key.substring(0, 16).getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }
}


