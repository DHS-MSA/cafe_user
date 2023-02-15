package com.cafe.user.controller;

import com.cafe.user.dto.UserInfoDTO;
import com.cafe.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable String userId) throws Exception {
        UserInfoDTO user = userService.getUserInfo();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
