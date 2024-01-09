package com.halo.eventer.swagger.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "부스 단일 조회", description = "(임시) 부스 id로 조회")
@ApiResponse(responseCode = "200", description = "이벤트 목록 조회 성공",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = {
                        @ExampleObject(name = "이벤트 목록",
                                value = "[\n" +
                                        "    {\n" +
                                        "        \"id\": 3,\n" +
                                        "        \"tag\": \"이벤트\",\n" +
                                        "        \"name\": \"지지지\",\n" +
                                        "        \"summary\": \"세종대학교 지지학과 이벤트\",\n" +
                                        "        \"latitude\": 242.12,\n" +
                                        "        \"longitude\": 112.46,\n" +
                                        "        \"isOperation\": false,\n" +
                                        "        \"operationHours\": \"24시간\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "        \"id\": 4,\n" +
                                        "        \"tag\": \"이벤트\",\n" +
                                        "        \"name\": \"지지지\",\n" +
                                        "        \"summary\": \"세종대학교 지지학과 이벤트\",\n" +
                                        "        \"latitude\": 242.12,\n" +
                                        "        \"longitude\": 112.46,\n" +
                                        "        \"isOperation\": false,\n" +
                                        "        \"operationHours\": \"24시간\"\n" +
                                        "    }\n" +
                                        "]",
                                summary = "이벤트 목록 조회 성공", description = "이벤트 목록을 성공적으로 가져온 경우의 예제입니다.")
                }))
public @interface GetEventsApi {
}
