package com.puribot.ai_core.infrastructure.persistence;

import com.puribot.ai_core.domain.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByTargetPerson(String targetPerson);

    List<AuditLog> findByIsIncongruentTrue();
}

