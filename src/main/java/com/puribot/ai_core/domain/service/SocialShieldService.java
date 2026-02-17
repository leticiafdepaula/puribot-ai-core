package com.puribot.ai_core.domain.service;

import com.puribot.ai_core.domain.exceptions.FraudulentCareerPromiseException;
import com.puribot.ai_core.domain.exceptions.InvalidSystemDNAException;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SocialShieldService {

    private final GoogleAiGeminiChatModel model;

    public SocialShieldService(@Value("${GEMINI_API_KEY}") String apiKey) {
        this.model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }

    public String analyzeText(String input) {
        String systemInstruction = """
        Você é o Puribot, inspirado no Pompompurin, um guardião para pessoas neurodivergentes e surdas.
        Sua missão é detectar segundas intenções, ironia ou mentiras.
        
        Analise a frase do usuário: "%s"
        
        REGRAS DE RESPOSTA:
        1. Se a intenção for BOA e segura: Comece a resposta APENAS com o emoji "🍮" e explique de forma amigável por que a interação é segura.
        2. Se houver MÁ-FÉ ou PERIGO: Use o alerta "🚨", identifique a possível malícia (sarcasmo, deboche ou mentira), cite a lei ou artigo infringido (Código Civil, Penal ou Trabalhista ou Administrativo) e sugira como o usuário pode responder para se proteger.
        
        "Mantenha um tom de um amigo(a) protetor e empático. Nunca use o nome 'Ge' ou 'Le' na resposta, trate a pessoa apenas como 'usuário' ou 'você'."
        """.formatted(input);

        String response = model.chat(systemInstruction);

        if (response.contains("🚨")) {

            if (input.toLowerCase().contains("vaga") || input.toLowerCase().contains("emprego") || input.toLowerCase().contains("promessa")) {
                throw new FraudulentCareerPromiseException("O Puribot detectou uma possível fraude em promessa de carreira: " + response);
            }
        }

        if (response == null || response.isBlank()) {
            throw new InvalidSystemDNAException("O cérebro do Puribot não conseguiu processar as instruções corretamente.");
        }

        return response;
    }
}