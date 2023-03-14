package com.cafe.user.service;

import com.cafe.user.domain.User;
import com.cafe.user.dto.RequestUserDTO;
import com.cafe.user.dto.ResponseUserDTO;

public interface UserService {

    public ResponseUserDTO getUserInfo(String userId) throws Exception;

    public ResponseUserDTO updateUserInfo(RequestUserDTO requestUserDTO) throws Exception;

    default User userDtoToEntity(ResponseUserDTO responseUserDTO){
        return  User.builder()
                .userId(responseUserDTO.getUserId())
                .name(responseUserDTO.getName())
                .address(responseUserDTO.getAddress())
                .phoneNumber(responseUserDTO.getPhoneNumber())
                .build();

    }
}
