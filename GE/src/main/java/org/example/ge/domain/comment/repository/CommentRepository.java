package org.example.ge.domain.comment.repository;

import org.example.ge.domain.comment.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    Optional<Comment> findById(Long id);

    List<Comment> findAllByPostId(Long postId);
}
