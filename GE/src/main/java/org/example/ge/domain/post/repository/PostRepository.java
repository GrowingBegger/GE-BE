package org.example.ge.domain.post.repository;

import org.example.ge.domain.expense.dto.response.ExpenseData;
import org.example.ge.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT DATE_FORMAT(created_at, '%m'), COALESCE(SUM(price), 0) " +
            "FROM post " +
            "WHERE DATE_FORMAT(created_at, '%Y') = :year AND user_id = :user_id " +
            "GROUP BY DATE_FORMAT(created_at, '%m') " +
            "ORDER BY 1 ASC", nativeQuery = true)
    List<Object[]> getYearSum(@Param("year") String year, @Param("user_id") Long UserId);

    List<Post> findAllByUserId(Long userId);
}
