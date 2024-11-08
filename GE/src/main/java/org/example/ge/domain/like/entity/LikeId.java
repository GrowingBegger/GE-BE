package org.example.ge.domain.like.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.user.entity.User;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeId implements Serializable {
    User user;
    Post post;
}
