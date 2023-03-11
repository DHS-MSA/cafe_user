package com.cafe.user.domain;

import com.cafe.user.dto.UserInfoDTO;

public interface UserCustomRepository {
    public UserInfoDTO getUserInfo(String userId) throws Exception;
}
