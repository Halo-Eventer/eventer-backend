package com.halo.eventer.entity;


import com.halo.eventer.dto.booth.BoothCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    public Booth(BoothCreateDto booth) {
        this.tag = booth.getTag();
        this.name = booth.getName();
        this.summary = booth.getSummary();
        this.latitude = booth.getLatitude();
        this.longitude = booth.getLongitude();
        this.isOperation = booth.getIsOperation();
        this.operationHours = booth.getOperationHours();
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
