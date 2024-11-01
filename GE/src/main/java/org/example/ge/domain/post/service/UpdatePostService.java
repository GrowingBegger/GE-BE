package org.example.ge.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.UpdatePostRequest;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.InvalidAuthorDeletionException;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UpdatePostService {
    private final PostRepository postRepository;

    public void updatePost(Long postId, Long userId, UpdatePostRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        if (post.getUserId().equals(userId)) {
            post.update(request.title(), request.content(), request.price());
        } else {
            throw InvalidAuthorDeletionException.EXCEPTION;
        }
    }
}
