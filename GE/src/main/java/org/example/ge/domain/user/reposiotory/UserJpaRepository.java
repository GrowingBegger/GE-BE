package org.example.ge.domain.user.reposiotory;

import org.example.ge.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<User, Long> {

    Optional<User> getUserByUsername (String username);

    Optional<User> getUserByUserId (Long id);
}
