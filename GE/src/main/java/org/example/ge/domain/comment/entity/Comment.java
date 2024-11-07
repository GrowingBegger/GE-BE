package org.example.ge.domain.comment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id", nullable = false, updatable = false)
    private Long postId;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "content", nullable = false, length = 80, updatable = true)
    private String content;
}
