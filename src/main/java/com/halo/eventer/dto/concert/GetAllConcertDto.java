package com.halo.eventer.dto.concert;

import com.halo.eventer.entity.Concert;
import com.halo.eventer.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class GetAllConcertDto {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;

    public GetAllConcertDto(Concert c) {
        this.id = c.getId();
        this.name = c.getName();
        this.latitude = c.getLatitude();
        this.longitude = c.getLongitude();
    }
}
