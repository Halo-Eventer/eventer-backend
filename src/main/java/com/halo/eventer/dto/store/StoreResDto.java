package com.halo.eventer.dto.store;

import com.halo.eventer.dto.menu.MenuResDto;
import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Menu;
import com.halo.eventer.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class StoreResDto {

    private String name;

    private String summary;
    private String content;

    private String location;
    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    private String type;

    private String thumbnail;

    private List<MenuResDto> menus;

    public StoreResDto(Store store) {
        this.name = store.getName();
        this.summary = store.getSummary();
        this.content = store.getContent();
        this.location = store.getLocation();
        this.isOperation = store.getIsOperation();
        this.operationHours = store.getOperationHours();
        this.type = store.getType().toString();
        this.thumbnail = store.getThumbnail();
        this.latitude = store.getLatitude();
        this.longitude = store.getLongitude();
    }

    public void setMenus(List<Menu> menus){
        this.menus = menus.stream().map(o->new MenuResDto(o)).collect(Collectors.toList());
    }
}
