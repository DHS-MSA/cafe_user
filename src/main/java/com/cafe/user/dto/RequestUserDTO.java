package com.cafe.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDTO {

    private String userId;
    private String name;
    private String address;
    private String phoneNumber;

    /**
     * 수정된 컬럼이 뭔지 구분하기 위한 필드
     * NAME : name / ADDRESS : address / PHONE : phoneNumber
     */
    private String colType;

}
