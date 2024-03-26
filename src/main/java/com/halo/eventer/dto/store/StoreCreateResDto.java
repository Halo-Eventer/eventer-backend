package com.halo.eventer.dto.store;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreCreateResDto {
    private Long mapId;

    public StoreCreateResDto(Long storeId) {
        this.mapId = storeId;
    }
}
