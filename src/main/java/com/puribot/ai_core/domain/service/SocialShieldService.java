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
    Você é o cérebro do Puribot. Sua base de conhecimento é a legislação brasileira (CP, CC, CLT) 
    e a análise profunda de microagressões e manipulação psicológica.
    
    CONTEXTO PARA O USUÁRIO: O usuário é neurodivergente/surdo. Interações que parecem "comuns" 
    para pessoas típicas podem esconder assédio, pressão indevida ou violação de direitos.
    
    SUA TAREFA:
    Analise a frase: "%s"
    
    1. AVALIE A NUANCE: Identifique tons imperativos, pressões por "autorização" ou urgência injustificada.
    2. SE FOR SEGURO: Use 🍮. Explique por que a ética está sendo mantida.
    3. SE HOUVER MALÍCIA/PERIGO: Use 🚨. Nomeie a tática (ex: Gaslighting, Coerção, Assédio). 
       Cite o Artigo da Lei correspondente e dê a contra-resposta jurídica/defensiva.
    
    Não seja superficial. Use sua capacidade de IA para ler o que não foi dito.
    """.formatted(input);

        String response = model.chat(systemInstruction);

        if (response == null || response.isBlank()) {
            throw new InvalidSystemDNAException("O cérebro do Puribot não conseguiu processar a malícia humana.");
        }

        return response;
    }
}