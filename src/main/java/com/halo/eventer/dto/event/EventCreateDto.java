package com.halo.eventer.dto.event;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EventCreateDto {
    private String tag;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;
}
