package com.empikproject.domain.mapper;

import com.empikproject.domain.GithubUser;
import com.empikproject.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(GithubUser githubUser) {
        return User.builder()
                .id(githubUser.getId())
                .login(githubUser.getLogin())
                .name(githubUser.getName())
                .type(githubUser.getType())
                .avatarUrl(githubUser.getAvatar_url())
                .createdAt(githubUser.getCreated_at())
                .calculations(calculate(githubUser.getFollowers(), githubUser.getPublic_repos()))
                .build();
    }

    private double calculate(int followers, int public_repos) {
        return 6.0/(double)followers * ((2.0+(double)public_repos));
    }
}
