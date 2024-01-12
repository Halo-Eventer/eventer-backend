package com.halo.eventer.swagger.notice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "공지사항 리스트 조회", description = "공지사항 한 개당 이미지, 이벤트명(title), 이벤트 간단설명(simpleExplanation)")
@ApiResponse(responseCode = "200", description = "공지사항 리스트 조회 성공",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = {
                        @ExampleObject(name = "공지사항 리스트",
                                value = "[\n" +
                                        "    {\n" +
                                        "        \"id\": 1,\n" +
                                        "        \"title\": \"반입 금지 물품 안내\",\n" +
                                        "        \"simpleExplanation\": \"안전하고 편안한 무대 관람을 위한 반입 금지 물품을 숙지해주세요!\",\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "        \"id\": 2,\n" +
                                        "        \"title\": \"배리어프리존 안내\",\n" +
                                        "        \"simpleExplanation\": \"모든 학우분들의 원활한 축제 참여를 위한 배리어프리존을 마련했습니다.\",\n" +
                                        "    }\n" +
                                        "]",
                                summary = "공지사항 리스트 조회 성공", description = "공지사항 리스트를 성공적으로 가져온 경우의 예제입니다.")
                }))
public @interface GetNoticesResApi {
}
