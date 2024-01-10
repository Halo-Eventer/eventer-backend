package com.halo.eventer.swagger.notice;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "공지사항 조회", description = "(임시) 공지사항 id로 조회")
public @interface GetNoticeReqApi {
}
