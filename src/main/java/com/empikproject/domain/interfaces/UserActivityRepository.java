package com.empikproject.domain.interfaces;

import com.empikproject.domain.UserActivity;

import java.util.Optional;

public interface UserActivityRepository {
    void create(UserActivity userActivity);
    void update(UserActivity userActivity);
    Optional<UserActivity> getUserActivity(String name);

}
