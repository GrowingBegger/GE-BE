package org.example.ge.domain.rating.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.rating.controller.dto.response.GetRatingResponse;
import org.example.ge.domain.rating.service.RatingService;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/ratings")
@RestController
public class RatingController {
    private final RatingService ratingService;
    private final CurrentUserProvider currentUserProvider;

    @GetMapping
    public GetRatingResponse getRating() {
        return ratingService.getRating(currentUserProvider.getCurrentUserId());
    }
}
