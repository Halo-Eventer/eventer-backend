package com.halo.eventer.map.swagger.store;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "상점 등록", description = "상점 정보 등록(관리자,관광안내소,편의점,화장실,쓰레기통,흡연장,주차장,기타)")
public @interface CreateStoreReqApi {
}
