package org.example.ge.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.comment.dto.request.CreateCommentRequest;
import org.example.ge.domain.comment.dto.request.UpdateCommentRequest;
import org.example.ge.domain.comment.service.CreateCommentService;
import org.example.ge.domain.comment.service.DeleteCommentService;
import org.example.ge.domain.comment.service.UpdateCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final UpdateCommentService updateCommentService;

    @PostMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void createComment(@PathVariable Long postId, @RequestBody CreateCommentRequest request) {
        createCommentService.execute(request, postId);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long commentId) {
        deleteCommentService.execute(commentId);
    }

    @PatchMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request) {
        updateCommentService.execute(request, commentId);
    }
}
