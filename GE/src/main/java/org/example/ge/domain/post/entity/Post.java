package org.example.ge.domain.post.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "title", length = 45, nullable = false, updatable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false, updatable = false)
    private String content;

    @Column(name = "image_url", length = 255, nullable = false, updatable = false)
    private String imageUrl;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "price", nullable = false, updatable = false)
    private BigDecimal price;
}
