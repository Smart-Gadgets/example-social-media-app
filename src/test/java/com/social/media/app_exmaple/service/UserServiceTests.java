package com.social.media.app_exmaple.service;

import com.social.media.app_exmaple.model.dto.UserReq;
import com.social.media.app_exmaple.model.entity.UserEntity;
import com.social.media.app_exmaple.repository.UserRepository;
import com.social.media.app_exmaple.services.UserService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTests {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void createUserGivenDuplicateUserNameThrowsBadRequestException() {

        UserReq userReq = new UserReq();
        userReq.setUserName("test");
        userReq.setEmail("test@test.com");
        UserEntity entity = new UserEntity();
        entity.setUserName("test");

        Mockito.when(userRepository.findByUserName("test")).thenReturn(entity);
        Throwable exception = assertThrows(BadRequestException.class, () -> userService.createUser(userReq));
        assertEquals("User with this userName already exists", exception.getMessage());
    }
}
