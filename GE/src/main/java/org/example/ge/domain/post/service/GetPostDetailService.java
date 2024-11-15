package org.example.ge.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.comment.entity.Comment;
import org.example.ge.domain.comment.repository.CommentRepository;
import org.example.ge.domain.like.entity.LikeType;
import org.example.ge.domain.like.repository.LikeRepository;
import org.example.ge.domain.post.dto.response.postDetail.CommentDto;
import org.example.ge.domain.post.dto.response.postDetail.GetPostDetailResponse;
import org.example.ge.domain.post.dto.response.postDetail.PostDto;
import org.example.ge.domain.post.dto.response.postDetail.UserDto;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPostDetailService {
    private final UserJpaRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    public GetPostDetailResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        User postWriter = userRepository.findById(post.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        UserDto postWriterDto = new UserDto(postWriter.getNickname(), postWriter.getProfile());

        PostDto postDto = new PostDto(post.getId(), post.getTitle(), post.getImageUrl(), post.getPrice(), post.getCreatedAt(), postWriterDto);

        List<Integer> likes = likeRepository.getLikeCntByPostId(postId);

        List<Comment> comments = commentRepository.findAllByPostId(postId);
        List<CommentDto> commentDto = comments.stream()
                .map((comment) -> {
                            User writer = userRepository.getUserByUserId(comment.getUserId())
                                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);
                            return new CommentDto(comment.getContent(),
                                    comment.getCreatedAt(),
                                    new UserDto(writer.getNickname(), writer.getProfile()));
                        }
                ).toList();

        return new GetPostDetailResponse(postDto, likes, commentDto);
    }
}
