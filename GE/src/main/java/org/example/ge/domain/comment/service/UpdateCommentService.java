package org.example.ge.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.comment.dto.request.UpdateCommentRequest;
import org.example.ge.domain.comment.entity.Comment;
import org.example.ge.domain.comment.exception.CommentNotExists;
import org.example.ge.domain.comment.exception.ForbiddenCommentException;
import org.example.ge.domain.comment.repository.CommentRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentService {
    private final CurrentUserProvider currentUserProvider;
    private final CommentRepository commentRepository;

    public void execute(UpdateCommentRequest request, Long commentId) {
        Long userId = currentUserProvider.getCurrentUserId();

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotExists.EXCEPTION);

        if (!comment.getUserId().equals(userId)) {
            throw ForbiddenCommentException.EXCEPTION;
        }

        comment.setContent(request.content());
        commentRepository.save(comment);
    }
}
