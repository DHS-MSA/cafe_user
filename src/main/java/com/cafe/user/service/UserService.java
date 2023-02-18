package com.cafe.user.service;

import com.cafe.user.domain.User;
import com.cafe.user.dto.UserInfoDTO;

public interface UserService {

    public UserInfoDTO getUserInfo(String userId) throws Exception;

    public UserInfoDTO updateUserInfo(UserInfoDTO userInfoDTO) throws Exception;

    default User userDtoToEntity(UserInfoDTO userInfoDTO){
        User user = User.builder()
                .userId(userInfoDTO.getUserId())
                .name(userInfoDTO.getName())
                .address(userInfoDTO.getAddress())
                .phoneNumber(userInfoDTO.getPhoneNumber())
                .build();

        return user;
    }
}
