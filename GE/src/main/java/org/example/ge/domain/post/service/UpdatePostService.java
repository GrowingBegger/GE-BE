package org.example.ge.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.UpdatePostRequest;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.InvalidAuthorDeletionException;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.mapper.UpdatePostParams;
import org.example.ge.domain.post.mapper.UpdatePostRequestMapper;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Transactional
@Service
public class UpdatePostService {
    private final PostRepository postRepository;

    private final UpdatePostRequestMapper updatePostRequestMapper;

    private final FileUploader fileUploader;

    public void updatePost(Long postId, Long userId, UpdatePostRequest request, MultipartFile image) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        String imageUrl = post.getImageUrl();

        if(image != null) {
            imageUrl = fileUploader.upload(image);
        }

        if (post.getUserId().equals(userId)) {
            postRepository.save(updatePostRequestMapper.toEntity(request, new UpdatePostParams(post.getId(), imageUrl)));
        } else {
            throw InvalidAuthorDeletionException.EXCEPTION;
        }
    }
}
