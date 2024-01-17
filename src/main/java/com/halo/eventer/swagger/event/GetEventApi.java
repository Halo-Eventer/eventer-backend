package com.halo.eventer.swagger.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "이벤트 단일 조회", description = "(임시) 이벤트 id로 조회")
@ApiResponse(responseCode = "200", description = "이벤트 정보 조회 성공",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = {
                        @ExampleObject(name = "이벤트 정보",
                                value = "{\n" +
                                        "    \"tag\": \"이벤트\",\n" +
                                        "    \"name\": \"돌려돌려 돌림판\",\n" +
                                        "    \"content\": \"안녕\",\n" +
                                        "    \"summary\": \"학생회관 앞 돌림판 이벤트\",\n" +
                                        "    \"location\": \"학생회관 앞\",\n" +
                                        "    \"isOperation\": false,\n" +
                                        "    \"operationHours\": \"24시간\",\n" +
                                        "    \"thumbnail\": \"url\",\n" +
                                        "    \"images\": [\n" +
                                        "        \"url2\",\n" +
                                        "        \"url3\"\n" +
                                        "    ]\n" +
                                        "}",
                                summary = "이벤트 정보 조회 성공", description = "이벤트 정보를 성공적으로 가져온 경우의 예제입니다.")
                }))
public @interface GetEventApi {
}
