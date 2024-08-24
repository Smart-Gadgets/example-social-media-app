package com.social.media.app_exmaple.model.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class UserReq {
    private String userId;
    private String userName;
    private String userAddress;
    private String email;
    private String phoneNo;
}
