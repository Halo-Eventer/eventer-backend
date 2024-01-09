package com.halo.eventer.swagger.amenity;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "편의시설 전체 조회", description = "(임시) 축제 id로 편의시설 조회")
@ApiResponse(responseCode = "200", description = "시설 목록 조회 성공",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = {
                        @ExampleObject(name = "시설 목록",
                                value = "[\n" +
                                        "    {\n" +
                                        "        \"id\": 1,\n" +
                                        "        \"tag\": \"편의시설\",\n" +
                                        "        \"name\": \"화장실\",\n" +
                                        "        \"summary\": \"세종대학교 공중 화장실\",\n" +
                                        "        \"latitude\": 242.12,\n" +
                                        "        \"longitude\": 112.46,\n" +
                                        "        \"isOperation\": false,\n" +
                                        "        \"operationHours\": \"24시간\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "        \"id\": 2,\n" +
                                        "        \"tag\": \"편의시설\",\n" +
                                        "        \"name\": \"화장실\",\n" +
                                        "        \"summary\": \"세종대학교 공중 화장실\",\n" +
                                        "        \"latitude\": 242.12,\n" +
                                        "        \"longitude\": 112.46,\n" +
                                        "        \"isOperation\": false,\n" +
                                        "        \"operationHours\": \"24시간\"\n" +
                                        "    },\n" +
                                        "    {\n" +
                                        "        \"id\": 3,\n" +
                                        "        \"tag\": \"편의시설\",\n" +
                                        "        \"name\": \"화장실\",\n" +
                                        "        \"summary\": \"세종대학교 공중 화장실\",\n" +
                                        "        \"latitude\": 242.12,\n" +
                                        "        \"longitude\": 112.46,\n" +
                                        "        \"isOperation\": false,\n" +
                                        "        \"operationHours\": \"24시간\"\n" +
                                        "    }\n" +
                                        "]",
                                summary = "시설 목록 조회 성공", description = "시설 목록을 성공적으로 가져온 경우의 예제입니다.")
                }))
public @interface GetAmenitiesApi {
}
