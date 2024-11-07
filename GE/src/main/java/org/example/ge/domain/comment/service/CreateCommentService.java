package org.example.ge.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.comment.dto.request.CreateCommentRequest;
import org.example.ge.domain.comment.entity.Comment;
import org.example.ge.domain.comment.mapper.CreateCommentParams;
import org.example.ge.domain.comment.mapper.CreateCommentRequestMapper;
import org.example.ge.domain.comment.repository.CommentRepository;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateCommentService {
    private final CurrentUserProvider currentUserProvider;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CreateCommentRequestMapper mapper;

    public void execute(CreateCommentRequest request, Long postId) {
        Long userId = currentUserProvider.getCurrentUserId();

        if (!postRepository.existsById(postId)) {
            throw PostNotFoundException.EXCEPTION;
        }
        
        commentRepository.save(mapper.toEntity(request, new CreateCommentParams(userId, postId)));
    }
}
