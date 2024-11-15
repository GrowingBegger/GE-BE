package org.example.ge.domain.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.controller.dto.request.UpdatePostRequest;
import org.example.ge.domain.post.controller.dto.response.CreatePostResponse;
import org.example.ge.domain.post.controller.dto.response.GetPostResponse;
import org.example.ge.domain.post.dto.response.postDetail.GetPostDetailResponse;
import org.example.ge.domain.post.entity.Post;
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

    private final GetPostDetailService getPostDetailService;

    @PostMapping
    public CreatePostResponse createPost(@RequestBody CreatePostRequest request) {
        Long userId = currentUserProvider.getCurrentUserId();
        return createPostService.execute(request, userId);
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

    @GetMapping("/{postId}")
    public GetPostDetailResponse getPostDetail(@PathVariable Long postId) {
        return getPostDetailService.execute(postId);
    }

    @GetMapping("/my")
    public List<GetPostResponse> getMyPosts() {
        Long userId = currentUserProvider.getCurrentUserId();
        return getPostService.getMyPosts(userId);
    }
}
