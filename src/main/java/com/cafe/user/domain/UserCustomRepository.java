package com.cafe.user.domain;

import com.cafe.user.dto.ResponseUserDTO;

public interface UserCustomRepository {
    public ResponseUserDTO getUserInfo(String userId) throws Exception;
}
