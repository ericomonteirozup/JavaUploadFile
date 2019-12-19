package com.baeldung.mongodb.file.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    
    @Id
    private String id;
    
    private String title;
        
    private Binary image;

    public Photo(String title) {
        super();
        this.title = title;
    }

    @Override
    public String toString() {
        return "Photo [id=" + id + ", title=" + title + ", image=" + image + "]";
    }
    
}
