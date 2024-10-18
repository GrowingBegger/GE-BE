package org.example.ge.instrastructure.common.user;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrentUserProviderImpl implements CurrentUserProvider {

    @Override
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    public String getCurrentUserName() {
        return null;
    }

    @Override
    public List<String> getCurrentUserRoles() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }
}
