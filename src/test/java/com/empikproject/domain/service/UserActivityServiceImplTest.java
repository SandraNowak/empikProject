package com.empikproject.domain.service;

import com.empikproject.domain.UserActivity;
import com.empikproject.domain.interfaces.UserActivityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserActivityServiceImplTest {

    @Mock
    private UserActivityRepository repository;

    @InjectMocks
    private UserActivityServiceImpl service;

    @Test
    public void shouldIncrementRequestCount_whenUserIsReturnedFromRepo() {

        UserActivity userActivity = UserActivity.builder()
                .login("sampleLogin")
                .request_count(10)
                .build();

        when(repository.getUserActivity("sampleLogin")).thenReturn(Optional.of(userActivity));

       service.handleUserActivity("sampleLogin");

        Mockito.verify(repository, Mockito.times(1)).update(argThat(c -> c.getRequest_count() == 11));
        Mockito.verify(repository, Mockito.never()).create(any());
    }

    @Test
    public void shouldCreateNEwEntry_WithRequestCountSetTo1_whenUserIsNotReturnedFromRepo() {

        when(repository.getUserActivity("sampleLogin")).thenReturn(Optional.empty());

        service.handleUserActivity("sampleLogin");

        Mockito.verify(repository, Mockito.times(1)).create(argThat(c -> c.getRequest_count() == 1));
        Mockito.verify(repository, Mockito.never()).update(any());
    }
}