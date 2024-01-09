package com.halo.eventer.dto.booth;


import com.halo.eventer.entity.Booth;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoothResDto {
    private Long id;

    private String tag;

    private String name;

    private String summary;

    private double latitude; // 위도
    private double longitude; // 경도

    private Boolean isOperation;

    private String operationHours;

    public BoothResDto(Booth b){
        this.id = b.getId();
        this.tag = b.getTag();
        this.name = b.getName();
        this.summary = b.getSummary();
        this.latitude = b.getLatitude();
        this.longitude = b.getLongitude();
        this.isOperation = b.getIsOperation();
        this.operationHours = b.getOperationHours();
    }
}
