package com.halo.eventer.swagger.festival;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "축제 정보 수정 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "축제 정보",
                                        value = "{\n" +
                                                "    \"id\": 1,\n" +
                                                "    \"name\": \"대동제\",\n" +
                                                "    \"content\": \"세종대학교 축제\",\n" +
                                                "    \"image\": \"url\",\n" +
                                                "    \"location\": \"주소\"\n" +
                                                "}",
                                        summary = "축제 정보 수정 성공", description = "축제 정보를 성공적으로 수정한 경우 수정된 정보가 response로 전달")
                        }))
})
public @interface UpdateResApi {
}
