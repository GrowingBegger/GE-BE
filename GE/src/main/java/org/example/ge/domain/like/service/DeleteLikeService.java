package org.example.ge.domain.like.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.like.entity.Like;
import org.example.ge.domain.like.entity.LikeId;
import org.example.ge.domain.like.execption.LikeNotFoundException;
import org.example.ge.domain.like.repository.LikeRepository;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLikeService {
    private final CurrentUserProvider currentUserProvider;
    private final UserJpaRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public void execute(Long postId) {
        Long userId = currentUserProvider.getCurrentUserId();

        User user = userRepository.getUserByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Like like = likeRepository.findById(new LikeId(user, post))
                .orElseThrow(() -> LikeNotFoundException.EXCEPTION);

        likeRepository.delete(like);
    }
}
