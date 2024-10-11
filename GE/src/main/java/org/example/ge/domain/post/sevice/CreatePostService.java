package org.example.ge.domain.post.sevice;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class CreatePostService {
    private final PostRepository postRepository;

    private final FileUploader fileUploader;

    public void execute(CreatePostRequest request, Long userId, MultipartFile image) {
        String imageUrl = fileUploader.upload(image);
        postRepository.save(request.toEntity(userId, imageUrl));
    }
}
