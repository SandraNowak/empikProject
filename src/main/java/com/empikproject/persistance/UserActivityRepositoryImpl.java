package com.empikproject.persistance;

import com.empikproject.domain.UserActivity;
import com.empikproject.domain.interfaces.UserActivityRepository;
import com.empikproject.persistance.mapper.UserActivityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserActivityRepositoryImpl implements UserActivityRepository {

    private final UserActivityCrudRepository crudRepository;
    private final UserActivityMapper mapper;

    public UserActivityRepositoryImpl(UserActivityCrudRepository crudRepository, UserActivityMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public void create(UserActivity userActivity) {
        crudRepository.save(mapper.toUserActivityPo(userActivity));
    }

    //ToDo optimistic lock should be used here to avoid inconsistency from parallel request
    @Override
    public void update(UserActivity userActivity) {
        crudRepository.save(mapper.toUserActivityPo(userActivity));
    }
    @Override
    public Optional<UserActivity> getUserActivity(String login) {
        return mapper.toUserActivity(crudRepository.findById(login));
    }
}
