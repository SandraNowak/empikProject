package com.empikproject.domain.mapper;

import com.empikproject.domain.GithubUser;
import com.empikproject.domain.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserMapperTest {

    private final UserMapper mapper = new UserMapper();

    @ParameterizedTest
    @MethodSource("calculationData")
    public void should_mappedAndMadeCalculation(double followers, double public_repos, double expectedCalculation) {

        //given
        GithubUser githubUser = GithubUser.builder()
                .login("skone")
                .id(123)
                .avatar_url("linkToAvatar")
                .type("User")
                .name("pol-skone")
                .public_repos((int)public_repos)
                .followers((int)followers)
                .created_at("2011-01-25T18:44:36Z")
                .build();

        //when
        User mappedUser = mapper.toUser(githubUser);

        //then
        assertAll(
                () -> assertEquals(githubUser.getName(), mappedUser.getName()),
                () -> assertEquals(githubUser.getId(), mappedUser.getId()),
                () -> assertEquals(githubUser.getLogin(), mappedUser.getLogin()),
                () -> assertEquals(githubUser.getAvatar_url(), mappedUser.getAvatarUrl()),
                () -> assertEquals(githubUser.getCreated_at(), mappedUser.getCreatedAt()),
                () -> assertEquals(expectedCalculation, mappedUser.getCalculations())
        );
    }

private static Stream<Arguments> calculationData() {
        return Stream.of(
                Arguments.of(6, 3, 5),
                Arguments.of(32, 8, 1.875),
                Arguments.of(21, 7, 2.571428571428571)
        );
    }
}
