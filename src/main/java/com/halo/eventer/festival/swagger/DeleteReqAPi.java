package com.halo.eventer.festival.swagger;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "축제 삭제", description = "축제 id로 삭제")
public @interface DeleteReqAPi {
}
