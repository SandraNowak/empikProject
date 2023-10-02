package com.empikproject.externalServiceintegration.github;

import lombok.Getter;

@Getter
public class GithubUserResponse {

    private int id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private int followers;
    private int public_repos;
}
