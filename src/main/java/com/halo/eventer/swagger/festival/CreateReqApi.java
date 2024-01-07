package com.halo.eventer.swagger.festival;


import io.swagger.v3.oas.annotations.Operation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "축제 등록", description = "축제 정보 등록")
public @interface CreateReqApi {
}
