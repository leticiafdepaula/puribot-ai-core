package com.puribot.ai_core.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String deviceSource;
    private String targetPerson;

    @Column(columnDefinition = "TEXT")
    private String rawTranscript;

    @Column(columnDefinition = "TEXT")
    private String socialTranslation;

    private String detectedSentiment;

    private String vocalToneAnalysis;
    private boolean isIncongruent;
    private Double maliceProbability;


    private String infringedLaw;

    @Column(columnDefinition = "TEXT")
    private String lawDescription;

    @Column(columnDefinition = "TEXT")
    private String suggestedDefense;

    @Column(unique = true, length = 64)
    private String digitalHash;

    private String encryptionVersion;

    private boolean isReported;

    private String audioOffset;

}

