package org.example.ge.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.InvalidAuthorDeletionException;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class DeletePostService {
    private final PostRepository postRepository;

    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        if (post.getUserId().equals(userId)) {
            postRepository.delete(post);
        } else {
            throw InvalidAuthorDeletionException.EXCEPTION;
        }
    }
}
