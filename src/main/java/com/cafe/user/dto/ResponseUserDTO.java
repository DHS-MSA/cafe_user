package com.cafe.user.dto;

import com.cafe.user.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDTO {

    private String userId;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDateTime createdAt;


    public ResponseUserDTO(User user){
        userId = user.getUserId();
        name = user.getName();
        address = user.getAddress();
        phoneNumber = user.getPhoneNumber();
        createdAt = user.getCreatedAt();
    }
}
