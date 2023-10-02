package com.empikproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GithubUser {

    private String login;
    private int id;
    private String avatar_url;
    private String type;
    private String name;
    private int public_repos;
    private int followers;
    private String created_at;
}
