package com.puribot.ai_core.infrastructure.config;

import org.springframework.stereotype.Component;

@Component
public class PuribotManifest {

    private final String author = "Le (Brain of Puribot)";
    private final String icon = "🍮 (Pudim/Pompompurin)";
    private final String purpose = "Protection of neurodivergent individuals against ethical fraud";
    private final String version = "1.0.0-BETA";

    public String getAuthor() { return author; }
    public String getIcon() { return icon; }
    public String getPurpose() { return purpose; }
    public String getVersion() { return version; }
}
