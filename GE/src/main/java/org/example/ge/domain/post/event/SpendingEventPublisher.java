package org.example.ge.domain.post.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpendingEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void publishSpendingEvent(Long userId, Double spendingAmount) {
        SpendingEvent event = new SpendingEvent(userId, spendingAmount);
        eventPublisher.publishEvent(event);
    }
}
