package com.halo.eventer.swagger.store;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(responseCode = "200", description = "가게 정보 생성 성공",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = {
                        @ExampleObject(name = "가게 정보 생성 성공 예제",
                                value = "{\"storeId\": \"6\"}",
                                summary = "가게 정보 생성 성공 예제", description = "가게 정보를 성공적으로 생성한 경우의 예제입니다.")
                }))
public @interface CreateStoreResApi {
}
