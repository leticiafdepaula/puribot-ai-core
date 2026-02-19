package com.puribot.ai_core.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(InvalidSystemDNAException.class)
    public ResponseEntity<Object> handleDNAViolation(InvalidSystemDNAException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.FORBIDDEN.value());
        body.put("error", "Security Violation");
        body.put("message", ex.getMessage());
        body.put("pudim_protection", "🍮 ACTIVE");

        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(PuribotException.class)
    public ResponseEntity<String> handlePuribotException(PuribotException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(FraudulentCareerPromiseException.class)
    public ResponseEntity<Map<String, Object>> handleAbuso(FraudulentCareerPromiseException ex) {
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("puribot_alert", "💢💢💢");
        response.put("analise", ex.getMessage());
        response.put("acao", "Verificar registro no CRP e preparar defesa.");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

