package com.cafe.user.service.impl;

import com.cafe.user.domain.UserCustomRepository;
import com.cafe.user.dto.UserInfoDTO;
import com.cafe.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCustomRepository userCustomRepository;

    @Override
    public UserInfoDTO getUserInfo() throws Exception {
        return userCustomRepository.getUserInfo();
    }
}
