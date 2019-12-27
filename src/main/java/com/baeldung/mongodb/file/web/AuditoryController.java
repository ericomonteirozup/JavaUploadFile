package com.baeldung.mongodb.file.web;

import com.baeldung.mongodb.file.models.Auditory;
import com.baeldung.mongodb.file.services.AuditoryService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuditoryController {

    @Autowired
    private AuditoryService auditoryService;

    @PostMapping("/auditory/{entity}/{externalId}")
    public ResponseEntity<Auditory> save(
            @PathVariable String entity,
            @PathVariable Long externalId,
            @RequestBody String jsonBody) {

        Document document = Document.parse(jsonBody);

        Auditory auditory = new Auditory();
        auditory.setEntity(entity);
        auditory.setExternalId(externalId);
        auditory.setDocument(document);
        auditory.setVersion(2L);

        auditory = auditoryService.add(auditory);
        return ResponseEntity.ok(auditory);
    }

}
