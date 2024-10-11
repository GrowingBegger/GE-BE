package org.example.ge.domain.post.sevice;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CretePostService {
    public void execute(CreatePostRequest request, Long userId) {
        // TODO :: 이미지 S3 업로드 로직 작성

    }
}
