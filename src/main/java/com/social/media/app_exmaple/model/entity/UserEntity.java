package com.social.media.app_exmaple.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String userAddress;
    private String email;
    private String phoneNo;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
