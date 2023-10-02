package com.empikproject.domain.service;

import com.empikproject.domain.User;
import com.empikproject.domain.interfaces.GithubClient;
import com.empikproject.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private  final GithubClient githubClient;
    private final UserMapper userMapper;
    private final UserActivityService userActivityService;

    public UserServiceImpl(GithubClient githubClient, UserMapper userMapper, UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
        this.githubClient = githubClient;
        this.userMapper = userMapper;
    }

    @Override
    public User get(String login) {
        var githubUser = githubClient.get(login);
        userActivityService.handleUserActivity(login);
        return userMapper.toUser(githubUser);
    }
}
