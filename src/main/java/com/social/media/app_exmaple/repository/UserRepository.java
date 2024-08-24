package com.social.media.app_exmaple.repository;

import com.social.media.app_exmaple.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public UserEntity findByUserName(String username);
    public Optional<UserEntity> findById(String userId);
    public UserEntity save(UserEntity user);
}
