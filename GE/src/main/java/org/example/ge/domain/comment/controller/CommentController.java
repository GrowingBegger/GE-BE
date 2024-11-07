package org.example.ge.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.comment.dto.request.CreateCommentRequest;
import org.example.ge.domain.comment.service.CreateCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CreateCommentService createCommentService;

    @PostMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void createComment(@PathVariable Long postId, @RequestBody CreateCommentRequest request) {
        createCommentService.execute(request, postId);
    }
}
