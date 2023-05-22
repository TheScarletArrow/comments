package ru.scarlet.comments;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public Comments create(CommentsIn in, HttpServletRequest request){
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String refresh_token = authorizationHeader.substring("Bearer ".length());

        Algorithm algorithm = Algorithm.HMAC256("secretScarletH!NtSTheR@wT0L!ghTwHeNtheD4rKD!eSsecretScarletH!NtSTheR@wT0L!ghTwHeNtheD4rKD!eSsecretScarletH!NtSTheR@wT0L!ghTwHeNtheD4rKD!eS".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT jwt = verifier.verify(refresh_token);
        String username = jwt.getSubject();
        Comments comments = new Comments();
        comments.setText(in.getText());
        comments.setUsername(username);
        comments.setMapUUID(in.getMapUUID().toString());
        comments.setReplyTo(in.getReplyTo());

        return commentRepository.save(comments);
    }
}
