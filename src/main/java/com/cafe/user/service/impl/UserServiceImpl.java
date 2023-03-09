package com.cafe.user.service.impl;

import com.cafe.user.domain.User;
import com.cafe.user.domain.UserCustomRepository;
import com.cafe.user.domain.UserRepository;
import com.cafe.user.dto.UserInfoDTO;
import com.cafe.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserCustomRepository userCustomRepository;
    private final UserRepository userRepository;

    @Override
    public UserInfoDTO getUserInfo(String userId) throws Exception {
        return userCustomRepository.getUserInfo(userId);
    }

    @Transactional
    @Override
    public User updateUserInfo(UserInfoDTO userInfoDTO) throws Exception {

        User user = userRepository.findByUserId(userInfoDTO.getUserId()); //TODO dto를 수정해야할 것 같은데.......
        user.updateUserByColType(userInfoDTO);

/*        System.out.println(userInfoDTO.getColType());
        switch (userInfoDTO.getColType()){
            case "N": // name
                user = User
                        .builder()
                        .name(userInfoDTO.getName())
                        .build();
                break;

            case "A": // address
                user = User
                        .builder()
                        .address(userInfoDTO.getAddress())
                        .build();
                break;

            case "P": // phone number'
                user = User
                        .builder()
                        .phoneNumber(user.getPhoneNumber())
                        .build();
                break;

        }
        userRepository.save(user);*/
        return user;
    }
}
