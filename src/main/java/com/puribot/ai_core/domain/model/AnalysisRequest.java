/*
 * Property of Le - Creator of Puribot AI
 * Copyright (c) 2026. All rights reserved.
 * * This code is part of the Puribot-AI-Core project.
 * Unauthorized copying, modification, or distribution is strictly prohibited.
 * Purpose: Detecting ethical infractions and protecting neurodivergent individuals.
 * Contact: [leticiaferreira150998@gmail.com]
 */

package com.puribot.ai_core.domain.model;

import com.puribot.ai_core.domain.enums.VocalIntonation;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnalysisRequest {
        private String transcribedText;
        private VocalIntonation intonation;
        private String context;
    }

