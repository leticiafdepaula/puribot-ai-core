package com.puribot.ai_core.domain.enums;

import lombok.Getter;

@Getter
public enum VocalIntonation {

    MANIPULATIVE_SWEETNESS("Sweet or mellow voice used to hide malicious intent or coercion."),
    SARCASTIC_MOCKERY("Laughing intonation or exaggerated emphasis used to ridicule."),
    VEILED_AGGRESSION("Calm but cold and sharp tone used to threaten without shouting."),
    COERCIVE_AUTHORITY("Imposing tone to force submission or cause self-doubt (Gaslighting)."),
    PREDATORY_MALICE("Intonation indicating hidden agendas, unethical behavior, or 'safadeza'."),
    HONEST_NEUTRAL("Literal communication, no hidden layers of manipulation.");

    private final String description;

    VocalIntonation(String description) {
        this.description = description;
    }
}
