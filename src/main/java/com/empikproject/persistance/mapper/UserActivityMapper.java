package com.empikproject.persistance.mapper;

import com.empikproject.domain.UserActivity;
import com.empikproject.persistance.UserActivityPo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserActivityMapper {

    public UserActivityPo toUserActivityPo(UserActivity userActivity) {
        return UserActivityPo.builder()
                .login(userActivity.getLogin())
                .request_count(userActivity.getRequest_count())
                .build();
    }

    public UserActivity toUserActivity(UserActivityPo userActivityPo) {
        return UserActivity.builder()
                .login(userActivityPo.getLogin())
                .request_count(userActivityPo.getRequest_count())
                .build();
    }

    public Optional<UserActivity> toUserActivity(Optional<UserActivityPo> userActivityPo) {
        return userActivityPo.map(this::toUserActivity);
    }
}
