package com.puribot.ai_core.infrastructure.config;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public GoogleAiGeminiChatModel googleAiGeminiChatModel(@Value("${GEMINI_API_KEY}") String apiKey) {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }
}
