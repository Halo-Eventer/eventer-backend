package com.halo.eventer.map;



import com.halo.eventer.common.StoreType;
import com.halo.eventer.map.dto.map.StoreCreateDto;
import com.halo.eventer.festival.Festival;
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

    @Column(columnDefinition = "varchar(2000)")
    private String content;

    private String location;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;
    private String operationHours;

    private String thumbnail;


    @Enumerated(EnumType.STRING)
    private StoreType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Menu> menus = new ArrayList<>();


    @Builder
    public Store(StoreCreateDto storeCreateDto) {
        this.location = storeCreateDto.getLocation();
        this.content = storeCreateDto.getContent();
        this.name = storeCreateDto.getName();
        this.summary = storeCreateDto.getSummary();
        this.latitude = storeCreateDto.getLatitude();
        this.longitude = storeCreateDto.getLongitude();
        this.isOperation = storeCreateDto.getIsOperation();
        this.operationHours = storeCreateDto.getOperationHours();
        this.thumbnail = storeCreateDto.getThumbnail();
    }

    public void setStore(StoreCreateDto storeCreateDto) {
        this.location = storeCreateDto.getLocation();
        this.content = storeCreateDto.getContent();
        this.name = storeCreateDto.getName();
        this.summary = storeCreateDto.getSummary();
        this.latitude = storeCreateDto.getLatitude();
        this.longitude = storeCreateDto.getLongitude();
        this.isOperation = storeCreateDto.getIsOperation();
        this.operationHours = storeCreateDto.getOperationHours();
        this.thumbnail = storeCreateDto.getThumbnail();
    }

    public void setFestival(Festival festival){
        this.festival = festival;
    }

    public void setType (StoreType storeType){
        this.type = storeType;
    }
}
