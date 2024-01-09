package com.halo.eventer.dto.event;


import com.halo.eventer.entity.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventResDto {
    private Long id;

    private String tag;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    public EventResDto(Event e){
        this.id = e.getId();
        this.tag = e.getTag();
        this.name = e.getName();
        this.summary = e.getSummary();
        this.latitude = e.getLatitude();
        this.longitude = e.getLongitude();
        this.isOperation = e.getIsOperation();
        this.operationHours = e.getOperationHours();
    }
}
