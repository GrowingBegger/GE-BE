package org.example.ge.instrastructure.common.user;

import org.example.ge.instrastructure.security.auth.CustomUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrentUserProviderImpl implements CurrentUserProvider {

    @Override
    public Long getCurrentUserId() {
        return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).userId();
    }

    @Override
    public String getCurrentUserName() {
        return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @Override
    public List<String> getCurrentUserRoles() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }
}
