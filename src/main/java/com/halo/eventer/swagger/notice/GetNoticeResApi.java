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
                                                "    \"title\": \"반입 금지 물품 안내\",\n" +
                                                "    \"simpleExplanation\": \"안전하고 편안한 무대 관람을 위한 반입 금지 물품을 숙지해주세요!\",\n" +
                                                "    \"subtitle\": \"2023세종대학교 대동제 '해피세종데이' 무대 관람 구역 반입 금지 물품 안내\",\n" +
                                                "    \"content\": \"새로운 바람, 밝은 달 안녕하세요, 세종대학교 제 36대..\",\n" +
                                                "    \"updateTime\": \"2024-01-03T23:01:00\"\n" +
                                                "    \"festivalId\": \"1\",\n" +
                                                "}",
                                        summary = "공지사항 조회 성공", description = "공지사항 정보를 성공적으로 가져온 경우의 예제입니다.")
                        }))
})
public @interface GetNoticeResApi {
}
