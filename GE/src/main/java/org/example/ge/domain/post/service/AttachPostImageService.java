package org.example.ge.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.post.exception.InvalidAuthorDeletionException;
import org.example.ge.domain.post.exception.PostNotFoundException;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Transactional
@Service
public class AttachPostImageService {
    private final FileUploader fileUploader;

    private final PostRepository postRepository;
    public void attachImage(Long postId, Long userId, MultipartFile file) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);

        if (post.getUserId().equals(userId)) {
            String imageUrl = fileUploader.upload(file);
            post.updateImageUrl(imageUrl);
            postRepository.save(post);
        } else {
            throw new InvalidAuthorDeletionException();
        }
    }
}
