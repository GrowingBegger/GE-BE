package org.example.ge.domain.rating.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.rating.controller.dto.response.GetRatingResponse;
import org.example.ge.domain.rating.entity.Rating;
import org.example.ge.domain.rating.repository.RatingRepository;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    public GetRatingResponse getRating(Long userId) {
        Rating rating = ratingRepository.findByUserId(userId).orElseThrow(() ->
                UserNotFoundException.EXCEPTION);

        return new GetRatingResponse(rating.getRating());
    }
}
