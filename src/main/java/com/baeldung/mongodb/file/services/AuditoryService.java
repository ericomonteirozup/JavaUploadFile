package com.baeldung.mongodb.file.services;

import com.baeldung.mongodb.file.daos.AuditoryRepository;
import com.baeldung.mongodb.file.models.Auditory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditoryService {

    @Autowired
    private AuditoryRepository auditoryRepository;

    public Auditory add(Auditory auditory) {
        auditory.setVersion(getNewVersion(auditory.getEntity(), auditory.getExternalId()));
        return auditoryRepository.insert(auditory);
    }

    public Long getNewVersion(String entity, Long id) {
        Optional<Auditory> lastRegister = auditoryRepository.findFirstByEntityAndExternalIdOrderByVersionDesc(entity, id);

        if (lastRegister.isPresent())
            return lastRegister.get().getVersion() + 1;

        return 1L;
    }

}
