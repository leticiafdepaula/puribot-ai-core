package com.puribot.ai_core.domain.dto;

public record AuditRequestDTO(
        String text,
        String target,
        String source
) {}