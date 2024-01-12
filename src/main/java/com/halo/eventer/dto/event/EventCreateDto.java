package com.halo.eventer.dto.event;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class EventCreateDto {
    private String tag;

    private String name;

    private String summary;
    private String content;

    private double latitude; // 위도
    private double longitude; // 경도
    private String location;

    private Boolean isOperation;

    private String operationHours;
    private String thumbnail;
    private List<String> images;
}
