package org.example.ge.domain.like.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.like.dto.request.CreateLikeRequest;
import org.example.ge.domain.like.entity.Like;
import org.example.ge.domain.like.entity.LikeId;
import org.example.ge.domain.like.entity.LikeType;
import org.example.ge.domain.like.execption.EnumNotValidException;
import org.example.ge.domain.like.repository.LikeRepository;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateLikeService {
    private final CurrentUserProvider currentUserProvider;
    private final UserJpaRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public void execute(CreateLikeRequest request, Long postId) {
        Long userId = currentUserProvider.getCurrentUserId();
        User user = userRepository.getUserByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if (Arrays.stream(LikeType.values()).noneMatch(like -> like.name().equals(request.reaction()))) {
            throw EnumNotValidException.EXCEPTION;
        }

        LikeType likeType = LikeType.valueOf(request.reaction());

        likeRepository.save(Like.builder().likeType(likeType).user(user).post(post).build());
    }
}
