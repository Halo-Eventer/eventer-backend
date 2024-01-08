package com.halo.eventer.swagger.store;


import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "상점 등록", description = "상점 정보 등록(주점, 푸드트럭)")
public @interface CreateStoreReqApi {
}
