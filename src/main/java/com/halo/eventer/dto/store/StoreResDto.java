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
    private String content;

    private String location;

    private Boolean isOperation;

    private String operationHours;

    private String type;

    public StoreResDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.summary = store.getSummary();
        this.content = store.getContent();
        this.location = store.getLocation();
        this.isOperation = store.getIsOperation();
        this.operationHours = store.getOperationHours();
        this.type = store.getType().toString();
    }
}
