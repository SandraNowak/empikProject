package com.empikproject.externalServiceintegration.github.mapper;

import com.empikproject.domain.GithubUser;
import com.empikproject.externalServiceintegration.github.GithubUserResponse;
import org.springframework.stereotype.Component;

@Component
public class GithubUserMapper {

    public GithubUser toDomain(GithubUserResponse response) {
        return GithubUser.builder()
                .id(response.getId())
                .name(response.getName())
                .login(response.getLogin())
                .type(response.getType())
                .avatar_url(response.getAvatar_url())
                .created_at(response.getCreated_at())
                .followers(response.getFollowers())
                .public_repos(response.getPublic_repos())
                .build();
    }
}
