package org.example.ge.instrastructure.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService {
    private final UserJpaRepository userRepository;

    public UserDetails loadUserByUserId(Long userId) throws RuntimeException {
        User user = userRepository.getUserByUserId(userId).orElseThrow(RuntimeException::new);
        return new CustomUserDetail(user.getUserId(), user.getUsername());
    }
}
