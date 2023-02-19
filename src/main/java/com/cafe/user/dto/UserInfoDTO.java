package com.cafe.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    private String userId;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDateTime createdAt;

    /**
     * 수정된 컬럼이 뭔지 구분하기 위한 필드
     * N : name / A : address / P : phoneNumber
     */
    private String ColType;

}
