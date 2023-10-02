package com.empikproject.persistance;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserActivityPo {
    @Id
    private String login;
    private int request_count;
}
