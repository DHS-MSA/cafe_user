package com.cafe.user.controller;

import com.cafe.user.domain.User;
import com.cafe.user.dto.RequestUserDTO;
import com.cafe.user.dto.ResponseUserDTO;
import com.cafe.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/info/{userId}")
    public ResponseEntity<ResponseUserDTO> getUserInfo(@PathVariable String userId) throws Exception {
        ResponseUserDTO user = userService.getUserInfo(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/info/update")
    public ResponseEntity<ResponseUserDTO> updateUserInfo(@RequestBody RequestUserDTO requestUserDTO) throws Exception {
        ResponseUserDTO responseUserDTO = userService.updateUserInfo(requestUserDTO);// TODO 추후 로직 수정 , userId 파라미터
        return new ResponseEntity<>(responseUserDTO, HttpStatus.OK);

    }
}
