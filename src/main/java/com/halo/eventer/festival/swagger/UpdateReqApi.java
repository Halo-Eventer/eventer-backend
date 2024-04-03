package com.halo.eventer.festival.swagger;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "축제 수정", description = "축제 id로 수정")
public @interface UpdateReqApi {
}
