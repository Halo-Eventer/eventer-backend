package com.halo.eventer.entity;


import com.halo.eventer.dto.event.EventCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(columnDefinition = "varchar(500)")
    private String content;

    private double latitude; // 위도
    private double longitude; // 경도
    private String location;

    private Boolean isOperation;

    private String operationHours;

    private String thumbnail;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Image> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;


    public Event(EventCreateDto e){
        this.tag = e.getTag();
        this.name = e.getName();

        this.summary = e.getSummary();
        this.content = e.getContent();

        this.latitude = e.getLatitude();
        this.longitude = e.getLongitude();
        this.location = e.getLocation();

        this.isOperation = e.getIsOperation();
        this.operationHours = e.getOperationHours();

        this.thumbnail = e.getThumbnail();
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
