package com.empikproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserActivity {

    private String login;
    private int request_count;
}
