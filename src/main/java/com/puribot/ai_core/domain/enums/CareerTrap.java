package com.puribot.ai_core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum CareerTrap {
    FALSE_PROMISE_OF_PROMOTION("Promising growth or roles to extract more work without real intent."),
    CARROT_ON_A_STICK("Keeping a reward visible but unreachable to maintain productivity."),
    SELECTIVE_MERITOCRACY("Giving rewards to others despite previous promises to the user.");

    private final String description;

    CareerTrap(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}


