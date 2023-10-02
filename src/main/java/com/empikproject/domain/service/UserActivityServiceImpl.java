package com.empikproject.domain.service;

import com.empikproject.domain.UserActivity;
import com.empikproject.domain.interfaces.UserActivityRepository;
import org.springframework.stereotype.Component;

@Component
public class UserActivityServiceImpl implements UserActivityService{

    private final UserActivityRepository repository;

    public UserActivityServiceImpl(UserActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleUserActivity(String login) {
        var userActivity = repository.getUserActivity(login);
        if (userActivity.isPresent()) {
            UserActivity updateUser = userActivity.get();
            updateUser.setRequest_count(updateUser.getRequest_count() +1);
            repository.update(updateUser);
        } else {
            repository.create(UserActivity.builder()
                    .login(login)
                    .request_count(1)
                    .build());
        }
    }
}
