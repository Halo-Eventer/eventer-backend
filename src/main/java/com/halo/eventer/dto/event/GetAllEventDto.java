package com.halo.eventer.dto.event;

import com.halo.eventer.entity.Booth;
import com.halo.eventer.entity.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllEventDto {
    private Long id;
    private String name;
    private String summary;
    private String thumbnail;
    private double latitude; // 위도
    private double longitude; // 경도

    public GetAllEventDto(Event e) {
        this.id = e.getId();
        this.name = e.getName();
        this.thumbnail = e.getThumbnail();
        this.summary = e.getSummary();
        this.latitude = e.getLatitude();
        this.longitude = e.getLongitude();
    }
}
