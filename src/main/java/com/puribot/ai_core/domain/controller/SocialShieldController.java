package com.puribot.ai_core.domain.controller;

import com.puribot.ai_core.domain.dto.AuditRequestDTO;
import com.puribot.ai_core.domain.dto.PuribotResponseDTO;
import com.puribot.ai_core.domain.service.SocialShieldService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/analyze")
public class SocialShieldController {

    private final SocialShieldService service;

    public SocialShieldController(SocialShieldService service) {
        this.service = service;
    }

    @PostMapping
    public PuribotResponseDTO analyze(@RequestBody AuditRequestDTO payload) {
        String resultadoService = service.analyzeText(payload.text(), payload.target(), payload.source());

        return new PuribotResponseDTO("Resultado do Puribot", resultadoService, "INFO");
    }
}
