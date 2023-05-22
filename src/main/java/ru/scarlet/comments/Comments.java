package ru.scarlet.comments;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@Document
public class Comments {
    @Id
    private String id;
    private String username;
    private String mapUUID;
    private String text;

    private String replyTo;
}
