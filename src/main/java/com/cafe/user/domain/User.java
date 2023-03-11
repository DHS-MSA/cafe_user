package com.cafe.user.domain;

import com.cafe.user.dto.UserInfoDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User extends BaseTimeEntity{

    @Id
    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 1, nullable = false)
    private String activeYn;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String latitude;

    @Column(length = 100)
    private String longitude;


    public void updateUserByColType(UserInfoDTO userInfoDTO) {
        switch (userInfoDTO.getColType()){
            case "N": // name
                this.name = userInfoDTO.getName();
                break;

            case "A": // address
                this.address = userInfoDTO.getAddress();
                break;

            case "P": // phone number'
                this.phoneNumber = userInfoDTO.getPhoneNumber();
                break;
        }
    }
}
