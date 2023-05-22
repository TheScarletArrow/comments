package ru.scarlet.comments;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
public class CommentsIn {
    private String username;
    private UUID mapUUID;
    private String text;

    private String replyTo;
}
