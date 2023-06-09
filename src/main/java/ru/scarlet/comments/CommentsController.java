package ru.scarlet.comments;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CommentsController {
    private final CommentService commentService;
    @PostMapping("/comments")
    public Comments create(@RequestBody CommentsIn in, HttpServletRequest request){
        return commentService.create(in, request);
    }

}
