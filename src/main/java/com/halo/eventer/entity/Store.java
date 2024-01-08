package com.halo.eventer.entity;



import com.halo.eventer.common.StoreType;
import com.halo.eventer.dto.store.StoreCreateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    @Enumerated(EnumType.STRING)
    private StoreType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Menu> menus = new ArrayList<>();

    @Builder
    public Store(StoreCreateDto storeCreateDto) {
        this.name = storeCreateDto.getName();
        this.summary = storeCreateDto.getSummary();
        this.latitude = storeCreateDto.getLatitude();
        this.longitude = storeCreateDto.getLongitude();
        this.isOperation = storeCreateDto.getIsOperation();
        this.operationHours = storeCreateDto.getOperationHours();
    }

    public void setStore(StoreCreateDto storeCreateDto) {
        this.name = storeCreateDto.getName();
        this.summary = storeCreateDto.getSummary();
        this.latitude = storeCreateDto.getLatitude();
        this.longitude = storeCreateDto.getLongitude();
        this.isOperation = storeCreateDto.getIsOperation();
        this.operationHours = storeCreateDto.getOperationHours();
    }

    public void setFestival(Festival festival){
        this.festival = festival;
    }

    public void setType (StoreType storeType){
        this.type = storeType;
    }
}
