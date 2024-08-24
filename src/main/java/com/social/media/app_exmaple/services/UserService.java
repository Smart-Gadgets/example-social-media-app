package com.social.media.app_exmaple.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.media.app_exmaple.model.dto.UserReq;
import com.social.media.app_exmaple.model.entity.UserEntity;
import com.social.media.app_exmaple.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    public final UserRepository userRepository;
    private final ObjectMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, ObjectMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserReq createUser(UserReq userReq) throws BadRequestException {
        var existingUser =  userRepository.findByUserName(userReq.getUserName());
        if (ObjectUtils.isEmpty(existingUser)) {
            var userEntity = mapper.convertValue(userReq, UserEntity.class);
            userEntity.setUserId(UUID.randomUUID().toString());
            var response = userRepository.save(userEntity);
            return mapper.convertValue(response, UserReq.class);
        } else{
            log.error("userName already exists for userName: {}", userReq.getUserName());
            throw new BadRequestException("User with this userName already exists");
        }
    }
}
