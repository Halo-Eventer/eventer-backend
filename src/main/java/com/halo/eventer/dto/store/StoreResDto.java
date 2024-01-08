package com.halo.eventer.dto.store;

import com.halo.eventer.entity.Menu;
import com.halo.eventer.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class StoreResDto {

    private Long id;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    private String type;

    public StoreResDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.summary = store.getSummary();
        this.latitude = store.getLatitude();
        this.longitude = store.getLongitude();
        this.isOperation = store.getIsOperation();
        this.operationHours = store.getOperationHours();
        this.type = store.getType().toString();
    }
}
