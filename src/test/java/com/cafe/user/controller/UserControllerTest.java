package com.cafe.user.controller;

import com.cafe.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_user_info() throws  Exception {
        mockMvc.perform(
                get("/user/info/{userId}","1")
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
}