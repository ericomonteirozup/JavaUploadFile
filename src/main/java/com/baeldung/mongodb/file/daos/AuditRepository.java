package com.baeldung.mongodb.file.daos;

import com.baeldung.mongodb.file.models.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AuditRepository extends MongoRepository<Audit, String> {

    public Optional<Audit> findFirstByEntityAndExternalIdOrderByVersionDesc(String entity, Long externalId);


}
