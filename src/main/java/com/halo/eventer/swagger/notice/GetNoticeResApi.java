package com.halo.eventer.swagger.notice;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "공지사항 조회 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "공지사항 정보",
                                        value = "{\n" +
                                                "    \"title\": \"주류 안내\",\n" +
                                                "    \"content\": \"모든 주류는 직접 구입해 주셔야 합니다.\",\n" +
                                                "    \"updateTime\": \"2024-01-03T23:01:00\"\n" +
                                                "}",
                                        summary = "공지사항 조회 성공", description = "공지사항 정보를 성공적으로 가져온 경우의 예제입니다.")
                        }))
})
public @interface GetNoticeResApi {
}
