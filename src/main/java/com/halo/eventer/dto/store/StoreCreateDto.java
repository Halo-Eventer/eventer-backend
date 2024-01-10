package com.halo.eventer.dto.store;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreCreateDto {

    private String name;

    private String summary;
    private String content;

    private Boolean isOperation;

    private String operationHours;

    private String location;
    private double latitude; // 위도
    private double longitude; // 경도

    private String thumbnail;

    private String type;

}
