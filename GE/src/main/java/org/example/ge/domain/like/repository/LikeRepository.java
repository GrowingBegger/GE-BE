package org.example.ge.domain.like.repository;

import org.example.ge.domain.like.entity.Like;
import org.example.ge.domain.like.entity.LikeId;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, LikeId> {

    Boolean existsByPostAndUser(Post post, User user);

    @Query(value = """
    SELECT COUNT(r.like_type) AS count
    FROM (SELECT 'Best' AS like_type UNION ALL SELECT 'Good' UNION ALL SELECT 'Bad') AS types
    LEFT JOIN recommend r ON r.like_type = types.like_type AND post_id = :postId
    GROUP BY types.like_type
    ORDER BY 
        CASE types.like_type
            WHEN 'Best' THEN 1
            WHEN 'Good' THEN 2
            WHEN 'Bad' THEN 3
        END
    """, nativeQuery = true)
    List<Integer> getLikeCntByPostId(@Param("postId") Long postId);
}
