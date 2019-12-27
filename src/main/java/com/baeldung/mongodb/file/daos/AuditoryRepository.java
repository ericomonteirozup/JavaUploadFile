package com.baeldung.mongodb.file.daos;

import com.baeldung.mongodb.file.models.Auditory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AuditoryRepository extends MongoRepository<Auditory, String> {

    public Optional<Auditory> findFirstByEntityAndExternalIdOrderByVersionDesc(String entity, Long externalId);


}
