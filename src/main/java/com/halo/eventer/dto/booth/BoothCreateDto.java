package com.halo.eventer.dto.booth;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoothCreateDto {

    private String tag;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;
}
