package com.cafe.user.controller;

import com.cafe.user.domain.User;
import com.cafe.user.dto.UserInfoDTO;
import com.cafe.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable String userId) throws Exception {
        UserInfoDTO user = userService.getUserInfo(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/info/update")
    public ResponseEntity<User> updateUserInfo(@RequestBody UserInfoDTO userInfoDTO) throws Exception {
        User user = userService.updateUserInfo(userInfoDTO); // TODO 추후 로직 수정 , userId 파라미터
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
