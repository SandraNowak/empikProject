package com.empikproject.domain.service;

import com.empikproject.domain.GithubUser;
import com.empikproject.domain.User;
import com.empikproject.domain.interfaces.GithubClient;
import com.empikproject.domain.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @Mock
    private GithubClient githubClient;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserActivityService userActivityService;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    public void shouldGetUser_whenUserExistOnGithub() {

        GithubUser githubUser = GithubUser.builder()
                .login("sampleLogin")
                .followers(10)
                .public_repos(3)
                .name("sampleName")
                .build();

        when(githubClient.get("sampleLogin")).thenReturn(githubUser);
        when(userMapper.toUser(githubUser)).thenCallRealMethod();

        User response = service.get("sampleLogin");
        assertAll(
                () -> assertEquals(githubUser.getName(), response.getName()),
                () -> assertEquals(githubUser.getId(), response.getId()),
                () -> assertEquals(githubUser.getLogin(), response.getLogin()),
                () -> assertEquals(githubUser.getAvatar_url(), response.getAvatarUrl()),
                () -> assertEquals(githubUser.getCreated_at(), response.getCreatedAt())
        );
        Mockito.verify(userActivityService, Mockito.atMostOnce()).handleUserActivity("sampleLogin");
    }

}