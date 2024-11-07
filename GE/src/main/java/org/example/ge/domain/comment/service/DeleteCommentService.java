package org.example.ge.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.comment.entity.Comment;
import org.example.ge.domain.comment.exception.CommentNotExists;
import org.example.ge.domain.comment.exception.ForbiddenCommentException;
import org.example.ge.domain.comment.repository.CommentRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {
    private final CurrentUserProvider currentUserProvider;
    private final CommentRepository commentRepository;

    public void execute(Long commentId) {
        Long userId = currentUserProvider.getCurrentUserId();

        Comment comment = commentRepository.findByPostId(commentId)
                .orElseThrow(() -> CommentNotExists.EXCEPTION);

        if (!comment.getUserId().equals(userId)) {
            throw ForbiddenCommentException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
