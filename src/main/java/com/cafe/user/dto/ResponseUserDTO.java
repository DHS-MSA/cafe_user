package com.cafe.user.dto;

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

}
