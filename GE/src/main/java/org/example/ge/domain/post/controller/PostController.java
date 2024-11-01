package org.example.ge.domain.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.controller.dto.request.UpdatePostRequest;
import org.example.ge.domain.post.controller.dto.response.GetPostResponse;
import org.example.ge.domain.post.service.*;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final CurrentUserProvider currentUserProvider;

    private final CreatePostService createPostService;

    private final GetPostService getPostService;

    private final DeletePostService deletePostService;

    private final UpdatePostService updatePostService;

    private final AttachPostImageService attachPostImageService;

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest request) {
        Long userId = currentUserProvider.getCurrentUserId();
        createPostService.execute(request, userId);
    }

    @GetMapping
    public List<GetPostResponse> getPosts() {
        return getPostService.getPosts();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        deletePostService.deletePost(id, currentUserProvider.getCurrentUserId());
    }

    @PatchMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest request ) {
        Long userId = currentUserProvider.getCurrentUserId();
        updatePostService.updatePost(id, userId, request);
    }

    @PostMapping("/{id}/image")
    public void attachImage(@PathVariable Long id, @RequestPart(value = "image", required = true) MultipartFile image) {
        Long userId = currentUserProvider.getCurrentUserId();
        attachPostImageService.attachImage(id, userId, image);
    }
}
