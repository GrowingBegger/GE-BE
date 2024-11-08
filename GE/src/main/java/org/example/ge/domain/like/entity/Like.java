package org.example.ge.domain.like.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.user.entity.User;

@Setter
@Getter
@Builder
@IdClass(LikeId.class)
@Entity(name = "recommend")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "id", nullable = false)
    private Post post;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LikeType likeType;
}
