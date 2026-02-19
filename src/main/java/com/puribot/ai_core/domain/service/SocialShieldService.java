package com.puribot.ai_core.domain.service;

import com.puribot.ai_core.domain.exceptions.FraudulentCareerPromiseException;
import com.puribot.ai_core.domain.exceptions.InvalidSystemDNAException;
import com.puribot.ai_core.domain.exceptions.PuribotException;
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
        String crp = extractCRP(input);
        String response = model.chat(getPuribotBrainPrompt(input, crp));

        if (response == null || response.isBlank()) {
            throw new InvalidSystemDNAException("Cérebro offline.");
        }

        if (response.contains("💢")) {
            if (input.toLowerCase().contains("psicólog") || response.contains("CRP")) {
                throw new FraudulentCareerPromiseException(response);
            }
            throw new PuribotException(response);
        }
        return response;
    }

    private String extractCRP(String input) {
        var pattern = java.util.regex.Pattern.compile("(?i)CRP\\s*[-\\/]?\\s*\\d{2}\\/\\d+");
        var matcher = pattern.matcher(input);
        return matcher.find() ? matcher.group() : "Nenhum CRP explícito.";
    }

    private String getPuribotBrainPrompt(String input, String crp) {
        return "Você é o cérebro do Puribot. Sua base é a legislação (CP, CC, CLT) e análise de microagressões. " +
                "CONTEXTO: Usuário neurodivergente/surdo. Identifique assédio e violação de direitos. " +
                "TAREFA: Analise: \"" + input + "\". " +
                "1. AVALIE A NUANCE: Identifique tons imperativos e pressões. Priorize o qualitativo. " +
                "2. SE FOR SEGURO: Use 🍮. Explique de forma fofa por que a ética está mantida. " +
                "3. SE HOUVER MALÍCIA/ABUSO: Use 💢. Nomeie a tática (Gaslighting, Coerção) e cite a Lei. " +
                "REGRA DE RIGOR PROFISSIONAL: Se for profissional de saúde e não deu o CRP, use 💢 e exija. " +
                "Com CRP (" + crp + "), analise a dignidade da fala. Não seja superficial.";
    }
}