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
                                        "        \"id\": 1,\n" +
                                        "        \"name\": \"이벤트 1\",\n" +
                                        "        \"latitude\": 223.12,\n" +
                                        "        \"longitude\": 112.46\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "        \"id\": 2,\n" +
                                        "        \"name\": \"이벤트 2\",\n" +
                                        "        \"latitude\": 113.12,\n" +
                                        "        \"longitude\": 555.46\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "        \"id\": 3,\n" +
                                        "        \"name\": \"이벤트 3\",\n" +
                                        "        \"latitude\": 422.12,\n" +
                                        "        \"longitude\": 311.46\n" +
                                        "    }\n" +
                                        "]",
                                summary = "부스 목록 조회 성공", description = "부스 목록을 성공적으로 가져온 경우의 예제입니다.")
                }))
public @interface GetEventsApi {
}
