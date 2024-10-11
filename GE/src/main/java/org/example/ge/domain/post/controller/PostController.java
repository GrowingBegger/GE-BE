package org.example.ge.domain.post.controller;

import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/post")
public class PostController {
    @PostMapping
    public void createPost(@RequestBody CreatePostRequest request, @RequestPart(value = "image") MultipartFile image) {

    }
}
