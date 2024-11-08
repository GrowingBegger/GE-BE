package org.example.ge.domain.rating.event;

import jakarta.transaction.Transactional;
import org.example.ge.domain.post.event.SpendingEvent;
import org.example.ge.domain.rating.entity.Rating;
import org.example.ge.domain.rating.exception.RatingNotFoundException;
import org.example.ge.domain.rating.repository.RatingRepository;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SpendingEventListener {
    private final RatingRepository ratingRepository;
    private final UserJpaRepository userRepository;

    public SpendingEventListener(RatingRepository ratingRepository, UserJpaRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @EventListener
    public void handleSpendingEvent(SpendingEvent event) {
        User user = userRepository.findById(event.userId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        Rating rating = ratingRepository.findByUserId(event.userId())
                .orElseThrow(() -> RatingNotFoundException.EXCEPTION);

        double spendingRatio = event.spendingAmount() / user.getTarget();

        double expIncrease;
        if (spendingRatio < 0.3) {
            expIncrease = 250;
        } else if (spendingRatio < 0.7) {
            expIncrease = 150;
        } else {
            expIncrease = 100;
        }

        // totalExp 증가
        rating.setTotalExp(rating.getTotalExp() + expIncrease);
        ratingRepository.save(rating);
    }
}