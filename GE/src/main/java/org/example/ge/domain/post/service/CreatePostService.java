package org.example.ge.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.controller.dto.response.CreatePostResponse;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.event.SpendingEventPublisher;
import org.example.ge.domain.post.mapper.CreatePostParams;
import org.example.ge.domain.post.mapper.CreatePostRequestMapper;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePostService {
    private final PostRepository postRepository;

    private final FileUploader fileUploader;

    private final CreatePostRequestMapper mapper;

    private final SpendingEventPublisher spendingEventPublisher;

    @Transactional
    public CreatePostResponse execute(CreatePostRequest request, Long userId) {
        Post post = postRepository.save(mapper.toEntity(request, new CreatePostParams(userId)));
        spendingEventPublisher.publishSpendingEvent(userId, post.getPrice().doubleValue());
        return new CreatePostResponse(post.getId());
    }
}
