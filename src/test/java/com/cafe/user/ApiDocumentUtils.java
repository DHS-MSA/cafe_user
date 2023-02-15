package com.cafe.user;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public interface ApiDocumentUtils {

    static OperationRequestPreprocessor getDocumentRequest() {
        return preprocessRequest(
                modifyUris() // (1) 문서상 uri를 기본값인 http://localhost:8080에서 https://docs.api.com으로 변경하기 위해 사용
                        .scheme("https")
                        .host("docs.api.com")
                        .removePort(),
                prettyPrint()); // (2) 문서의 request를 예쁘게 출력하기 위해 사용
    }

    static OperationResponsePreprocessor getDocumentResponse() {
        return preprocessResponse(prettyPrint()); // (3) 문서의 response를 예쁘게 출력하기 위해 사용
    }
}