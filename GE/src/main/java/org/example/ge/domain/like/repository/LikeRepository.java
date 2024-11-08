package org.example.ge.domain.like.repository;

import org.example.ge.domain.like.entity.Like;
import org.example.ge.domain.like.entity.LikeId;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, LikeId> {

    Boolean existsByPostAndUser(Post post, User user);
}
