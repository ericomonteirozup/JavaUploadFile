package com.baeldung.mongodb.file.web;

import com.baeldung.mongodb.file.models.Audit;
import com.baeldung.mongodb.file.services.AuditoryService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuditController {

    @Autowired
    private AuditoryService auditoryService;

    @PostMapping("/audit/{entity}/{externalId}")
    public ResponseEntity<Audit> save(
            @PathVariable String entity,
            @PathVariable Long externalId,
            @RequestBody String jsonBody) {

        Document document = Document.parse(jsonBody);

        Audit audit = new Audit();
        audit.setEntity(entity);
        audit.setExternalId(externalId);
        audit.setDocument(document);
        audit.setVersion(2L);

        audit = auditoryService.add(audit);
        return ResponseEntity.ok(audit);
    }

}
