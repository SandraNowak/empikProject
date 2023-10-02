package com.empikproject.externalServiceintegration.github;

import com.empikproject.domain.exception.ApiException;
import com.empikproject.domain.exception.ErrorCode;
import com.empikproject.externalServiceintegration.github.mapper.GithubUserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class GithubClientImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private GithubUserMapper mapper;

    @InjectMocks
    GithubClientImpl client;

    @Test
    public void shouldThrowNotFound_whenObjectNotExist() {

        String login = "login";
        String expectedErrorMessage = String.format("user with provided login {} not found", login);

        when(restTemplate.getForObject("https://api.github.com/users/{login}",
                GithubUserResponse.class, login)).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        ApiException exception = assertThrows(ApiException.class,
                () -> client.get(login));
        assertEquals(ErrorCode.NOT_FOUND, exception.getCode());
        assertEquals(expectedErrorMessage, exception.getMessage());

    }

}