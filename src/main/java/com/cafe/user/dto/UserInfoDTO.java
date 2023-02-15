package com.cafe.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDTO {

    private String userId;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDateTime createdAt;

}
