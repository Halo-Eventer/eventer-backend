package com.halo.eventer.entity;


import com.halo.eventer.dto.event.EventCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tag;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    public Event(EventCreateDto e){
        this.tag = e.getTag();
        this.name = e.getName();
        this.summary = e.getSummary();
        this.latitude = e.getLatitude();
        this.longitude = e.getLongitude();
        this.isOperation = e.getIsOperation();
        this.operationHours = e.getOperationHours();
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public void setAll(EventCreateDto e){
        this.tag = e.getTag();
        this.name = e.getName();
        this.summary = e.getSummary();
        this.latitude = e.getLatitude();
        this.longitude = e.getLongitude();
        this.isOperation = e.getIsOperation();
        this.operationHours = e.getOperationHours();
    }
}
