package com.puribot.ai_core.infrastructure.security;

import com.puribot.ai_core.domain.exceptions.InvalidSystemDNAException;
import com.puribot.ai_core.infrastructure.config.PuribotManifest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class IntegrityGuard {
    private final PuribotManifest manifest;

    public IntegrityGuard(PuribotManifest manifest) {
        this.manifest = manifest;
    }

    @PostConstruct
    public void validateOnStartup() {
        if (!"Le (Brain of Puribot)".equals(manifest.getAuthor())) {
            throw new InvalidSystemDNAException("O cérebro do Puribot não conseguiu processar as instruções corretamente.");
        }
    }
}
