package com.halo.eventer.swagger.festival;



import io.swagger.v3.oas.annotations.Operation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "축제 조회", description = "(임시) 축제 id로 조회")
public @interface GetReqApi {
}
