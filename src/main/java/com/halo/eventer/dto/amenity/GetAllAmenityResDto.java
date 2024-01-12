package com.halo.eventer.dto.amenity;


import com.halo.eventer.entity.Amenity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllAmenityResDto {
    private Long id;
    private String name;
    private double latitude; // 위도
    private double longitude; // 경도

    public GetAllAmenityResDto(Amenity a) {
        this.id = a.getId();
        this.name = a.getName();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
    }
}
