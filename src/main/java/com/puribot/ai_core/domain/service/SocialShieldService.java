package com.puribot.ai_core.domain.service;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.stereotype.Service;

@Service
public class SocialShieldService {

    private final GoogleAiGeminiChatModel model;
    private final AuditService auditService;

    public SocialShieldService(GoogleAiGeminiChatModel model, AuditService auditService) {
        this.model = model;
        this.auditService = auditService;
    }

    public String analyzeText(String input, String target, String source) {
        String prompt = "Analise a malícia nesta frase para um neurodivergente: " + input;
        String response = model.chat(prompt);

        return response.replace("\"", "'").replace("\n", " ").trim();
    }
    }
