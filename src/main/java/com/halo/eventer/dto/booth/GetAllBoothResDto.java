package com.halo.eventer.dto.booth;

import com.halo.eventer.entity.Booth;
import com.halo.eventer.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllBoothResDto {

    private Long id;
    private String name;
    private double latitude; // 위도
    private double longitude; // 경도

    public GetAllBoothResDto(Booth b) {
        this.id = b.getId();
        this.name = b.getName();
        this.latitude = b.getLatitude();
        this.longitude = b.getLongitude();
    }
}
