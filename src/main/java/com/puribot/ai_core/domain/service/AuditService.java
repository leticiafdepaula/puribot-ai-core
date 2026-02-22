package com.puribot.ai_core.domain.service;

import com.puribot.ai_core.domain.model.AuditLog;
import com.puribot.ai_core.infrastructure.persistence.AuditLogRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;



@Service

public class AuditService {

    private final AuditLogRepository auditLogRepository;

    public AuditService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void registrarEvidencia(String conversaCompleta, String analiseIa, String target, boolean hasMalice, String source) {
        AuditLog log = new AuditLog();
        log.setTimestamp(LocalDateTime.now());
        log.setRawTranscript(conversaCompleta);
        log.setSocialTranslation(analiseIa);
        log.setTargetPerson(target);
        log.setDeviceSource(source);
        log.setDetectedSentiment(hasMalice ? "MALÍCIA DETECTADA 💢" : "SEGURO 🍮");
        log.setAudioOffset("00:00");

        auditLogRepository.save(log);
    }
}