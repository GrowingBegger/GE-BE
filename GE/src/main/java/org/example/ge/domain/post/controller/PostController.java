package org.example.ge.domain.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.controller.dto.response.GetPostResponse;
import org.example.ge.domain.post.service.CreatePostService;
import org.example.ge.domain.post.service.DeletePostService;
import org.example.ge.domain.post.service.GetPostService;
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

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest request, @RequestPart(value = "image") MultipartFile image) {
        Long userId = currentUserProvider.getCurrentUserId();
        createPostService.execute(request, userId, image);
    }

    @GetMapping
    public List<GetPostResponse> getPosts() {
        return getPostService.getPosts();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        deletePostService.deletePost(id, currentUserProvider.getCurrentUserId());
    }
}
