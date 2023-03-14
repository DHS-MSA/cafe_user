package com.cafe.user.domain;

import com.cafe.user.dto.RequestUserDTO;
import com.cafe.user.dto.ResponseUserDTO;
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


    public void updateUserByColType(RequestUserDTO requestUserDTO) {
        switch (requestUserDTO.getColType()){
            case "NAME": // name
                this.name = requestUserDTO.getName();
                break;

            case "ADDRESS": // address
                this.address = requestUserDTO.getAddress();
                break;

            case "PHONE": // phone number
                this.phoneNumber = requestUserDTO.getPhoneNumber();
                break;
        }
    }



}
