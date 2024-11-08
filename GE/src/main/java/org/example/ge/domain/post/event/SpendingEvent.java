package org.example.ge.domain.post.event;

import lombok.Getter;

public record SpendingEvent(Long userId, Double spendingAmount) {
}