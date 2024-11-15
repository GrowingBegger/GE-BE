package org.example.ge.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.response.GetPostResponse;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.mapper.GetPostResponseMapper;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetPostService {
    private final PostRepository postRepository;

    private final GetPostResponseMapper getPostResponseMapper;

    private final UserJpaRepository userJpaRepository;

    public List<GetPostResponse> getPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(
                post -> {
                    User user = userJpaRepository.findById(post.getUserId()).orElseThrow(
                            () -> UserNotFoundException.EXCEPTION
                    );
                    return getPostResponseMapper.toDto(post, user);
                }
        ).toList();
    }

    public List<GetPostResponse> getMyPosts(Long userId) {
        List<Post> posts = postRepository.findAllByUserId(userId);
        User user = userJpaRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return posts.stream().map(
                post -> getPostResponseMapper.toDto(post, user)
        ).toList();
    }
}
