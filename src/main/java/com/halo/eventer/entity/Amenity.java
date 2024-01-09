package com.halo.eventer.entity;


import com.halo.eventer.dto.amenity.AmenityCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
public class Amenity {

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

    public Amenity(AmenityCreateDto a) {
        this.tag = a.getTag();
        this.name = a.getName();
        this.summary = a.getSummary();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
        this.isOperation = a.getIsOperation();
        this.operationHours = a.getOperationHours();
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
    public void setAll(AmenityCreateDto a) {
        this.tag = a.getTag();
        this.name = a.getName();
        this.summary = a.getSummary();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
        this.isOperation = a.getIsOperation();
        this.operationHours = a.getOperationHours();
    }

}
