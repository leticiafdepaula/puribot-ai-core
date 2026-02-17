package com.puribot.ai_core.domain.controller;

import com.puribot.ai_core.domain.service.SocialShieldService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analyze")
public class SocialShieldController {
    private final SocialShieldService service;

    public SocialShieldController(SocialShieldService service) {
        this.service = service;
    }

    @GetMapping
    public String analyze(@RequestParam String text) {
        return service.analyzeText(text);
    }
}

