package com.halo.eventer.swagger.notice;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "공지사항 리스트 조회", description = "이미지, 이벤트명, 이벤트 간단설명")
public @interface GetNoticesReqApi {
}
