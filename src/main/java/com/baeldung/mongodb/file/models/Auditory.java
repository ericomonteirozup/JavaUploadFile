package com.baeldung.mongodb.file.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auditory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auditory {
    @Id
    private String id;
    private String entity;
    private Long externalId;
    private Long version;
    private org.bson.Document document;
}
