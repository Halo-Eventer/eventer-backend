package com.halo.eventer.dto.store;


import com.halo.eventer.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllStoreResDto {

    private Long id;
    private String name;
    private double latitude; // 위도
    private double longitude; // 경도

    public GetAllStoreResDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.latitude = store.getLatitude();
        this.longitude = store.getLongitude();
    }
}
