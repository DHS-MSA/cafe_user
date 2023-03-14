package com.cafe.user.controller;

import com.cafe.user.domain.User;
import com.cafe.user.domain.UserRepository;
import com.cafe.user.dto.RequestUserDTO;
import com.cafe.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "gospel306.synology.me", uriPort = 8091)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void get_user_info() throws  Exception {
        mockMvc.perform(
                get("/user/info/{userId}","test")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(// 문서 작성 시작
                        document("get-user-info", preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("userId").description("사용자 아이디")
                                )
                                ,
                                responseFields(
                                        fieldWithPath("userId").type(JsonFieldType.STRING).description("사용자 아이디"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("사용자 이름").optional(),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("사용자 주소").optional(),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("사용자 번호").optional(),
                                        fieldWithPath("createdAt").type(JsonFieldType.STRING).description("사용자 가입일").optional()
                                )));
    }

    @Test
    @Rollback(value = false)
    public void update_user_info() throws  Exception {

        RequestUserDTO requestUserDTO = RequestUserDTO
                .builder()
                .userId("test")
                .name("수현")
                .colType("NAME")
                .build();


        User user = userRepository.findByUserId(requestUserDTO.getUserId());
        user.updateUserByColType(requestUserDTO);

        mockMvc.perform(
                        post("/user/info/update")
                                .content(objectMapper.writeValueAsString(requestUserDTO))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(// 문서 작성 시작
                        document("update-user-info", preprocessRequest(prettyPrint()),preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("userId").type(JsonFieldType.STRING).description("사용자 아이디"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("사용자 이름").optional(),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("사용자 주소").optional(),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("사용자 번호").optional(),
                                        fieldWithPath("colType").type(JsonFieldType.STRING).description("수정 타입(NAME/ADDRESS/PHONE)").optional()
                                )
                                ,
                                responseFields(
                                        fieldWithPath("userId").type(JsonFieldType.STRING).description("사용자 아이디"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("사용자 이름").optional(),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("사용자 주소").optional(),
                                        fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("사용자 번호").optional(),
                                        fieldWithPath("createdAt").type(JsonFieldType.STRING).description("사용자 가입일").optional()
                                )));
    }

}