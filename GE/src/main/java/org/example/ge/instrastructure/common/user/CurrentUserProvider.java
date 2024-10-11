package org.example.ge.instrastructure.common.user;

import java.util.List;

public interface CurrentUserProvider {
    Long getCurrentUserId();

    String getCurrentUserName();

    List<String> getCurrentUserRoles();

    boolean isAuthenticated();
}
