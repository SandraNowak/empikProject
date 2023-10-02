package com.empikproject.domain.interfaces;

import com.empikproject.domain.GithubUser;

public interface GithubClient {
    GithubUser get(String login);
}
