package com.empikproject.externalServiceintegration.github;

import com.empikproject.domain.GithubUser;
import com.empikproject.domain.exception.ApiException;
import com.empikproject.domain.exception.ErrorCode;
import com.empikproject.domain.exception.ServiceUnavailableException;
import com.empikproject.domain.interfaces.GithubClient;
import com.empikproject.externalServiceintegration.github.mapper.GithubUserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class GithubClientImpl implements GithubClient {

    private static final String GITHUB_URL = "https://api.github.com/users/{login}";
    private final RestTemplate restTemplate;
    private final GithubUserMapper mapper;

    public GithubClientImpl(RestTemplate restTemplate, GithubUserMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public GithubUser get(String login) {
        try {
            GithubUserResponse response = restTemplate.getForObject(GITHUB_URL,
                    GithubUserResponse.class, login);
            return mapper.toDomain(Objects.requireNonNull(response));
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ApiException(ErrorCode.NOT_FOUND, String.format("user with provided login %s not found", login));
            } throw new ServiceUnavailableException();
        }
    }
}
