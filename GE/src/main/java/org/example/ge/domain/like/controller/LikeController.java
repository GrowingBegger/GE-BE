package org.example.ge.domain.like.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.like.dto.request.CreateLikeRequest;
import org.example.ge.domain.like.service.CreateLikeService;
import org.example.ge.domain.like.service.DeleteLikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final CreateLikeService createLikeService;
    private final DeleteLikeService deleteLikeService;

    @PostMapping("/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLike(@RequestBody CreateLikeRequest request, @PathVariable("postId") Long postId) {
        createLikeService.execute(request, postId);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLike(@PathVariable("postId") Long postId) {
        deleteLikeService.execute(postId);
    }
}
