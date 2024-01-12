package com.halo.eventer.entity;


import com.halo.eventer.dto.booth.BoothCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Booth {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @OneToMany(mappedBy = "booth", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Image> images = new ArrayList<>();

    public Booth(BoothCreateDto booth) {
        this.tag = booth.getTag();
        this.name = booth.getName();
        this.summary = booth.getSummary();
        this.latitude = booth.getLatitude();
        this.longitude = booth.getLongitude();
        this.isOperation = booth.getIsOperation();
        this.operationHours = booth.getOperationHours();
        this.content = booth.getContent();
        this.location = booth.getLocation();
        this.thumbnail = booth.getThumbnail();
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
    public void setAll(BoothCreateDto booth) {
        this.tag = booth.getTag();
        this.name = booth.getName();
        this.summary = booth.getSummary();
        this.latitude = booth.getLatitude();
        this.longitude = booth.getLongitude();
        this.isOperation = booth.getIsOperation();
        this.operationHours = booth.getOperationHours();
    }
}
