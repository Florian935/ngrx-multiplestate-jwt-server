package com.florian935.ngrxmultiplestateauthjwtserver.controller;

import com.florian935.ngrxmultiplestateauthjwtserver.domain.Post;
import com.florian935.ngrxmultiplestateauthjwtserver.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        final List<Post> posts = postService.findAll();

        return ResponseEntity.ok(posts);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody Post post) {
        final Post postSaved = postService.insert(post);

        return ResponseEntity.status(CREATED).body(postSaved);
    }
}