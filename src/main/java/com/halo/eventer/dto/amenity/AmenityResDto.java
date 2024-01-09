package com.halo.eventer.dto.amenity;

import com.halo.eventer.entity.Amenity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class AmenityResDto {
    private Long id;

    private String tag;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    public AmenityResDto(Amenity amenity){
        this.id = amenity.getId();
        this.tag = amenity.getTag();
        this.name = amenity.getName();
        this.summary = amenity.getSummary();
        this.latitude = amenity.getLatitude();
        this.longitude = amenity.getLongitude();
        this.isOperation = amenity.getIsOperation();
        this.operationHours = amenity.getOperationHours();
    }
}
