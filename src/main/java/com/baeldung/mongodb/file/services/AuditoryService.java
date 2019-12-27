package com.baeldung.mongodb.file.services;

import com.baeldung.mongodb.file.daos.AuditRepository;
import com.baeldung.mongodb.file.models.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditoryService {

    @Autowired
    private AuditRepository auditRepository;

    public Audit add(Audit audit) {
        audit.setVersion(getNewVersion(audit.getEntity(), audit.getExternalId()));
        return auditRepository.insert(audit);
    }

    public Long getNewVersion(String entity, Long id) {
        Optional<Audit> lastRegister = auditRepository.findFirstByEntityAndExternalIdOrderByVersionDesc(entity, id);

        if (lastRegister.isPresent())
            return lastRegister.get().getVersion() + 1;

        return 1L;
    }

}
