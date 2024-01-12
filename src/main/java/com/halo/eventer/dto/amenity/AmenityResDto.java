package com.halo.eventer.dto.amenity;

import com.halo.eventer.entity.Amenity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class AmenityResDto {

    private String tag;

    private String name;

    private String summary;

    private String location;

    private Boolean isOperation;

    private String operationHours;

    public AmenityResDto(Amenity amenity){
        this.tag = amenity.getTag();
        this.name = amenity.getName();
        this.summary = amenity.getSummary();
        this.isOperation = amenity.getIsOperation();
        this.operationHours = amenity.getOperationHours();
        this.location = amenity.getLocation();
    }
}
