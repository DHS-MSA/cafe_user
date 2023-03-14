package com.cafe.user.service;

import com.cafe.user.domain.User;
import com.cafe.user.dto.RequestUserDTO;
import com.cafe.user.dto.ResponseUserDTO;

public interface UserService {

    public ResponseUserDTO getUserInfo(String userId) throws Exception;

    public User updateUserInfo(RequestUserDTO requestUserDTO) throws Exception;

}
