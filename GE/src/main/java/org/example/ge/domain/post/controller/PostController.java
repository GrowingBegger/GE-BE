package org.example.ge.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.sevice.CreatePostService;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final CurrentUserProvider currentUserProvider;

    private final CreatePostService createPostService;

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest request, @RequestPart(value = "image") MultipartFile image) {
        Long userId = currentUserProvider.getCurrentUserId();
        createPostService.execute(request, userId, image);
    }
}
