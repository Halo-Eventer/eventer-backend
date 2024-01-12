package com.halo.eventer.dto.booth;


import com.halo.eventer.entity.Booth;
import com.halo.eventer.entity.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoothResDto {

    private String tag;

    private String name;
    private String content;
    private String summary;

    private String location;


    private Boolean isOperation;

    private String operationHours;

    private String thumbnail;

    private List<String> images;


    public BoothResDto(Booth b){
        this.tag = b.getTag();
        this.name = b.getName();
        this.summary = b.getSummary();
        this.isOperation = b.getIsOperation();
        this.operationHours = b.getOperationHours();
        this.content = b.getContent();
        this.thumbnail = b.getThumbnail();
        this.location = b.getLocation();
    }

    public void setImages(List<Image> images){
        this.images = images.stream().map(o->o.getImage_url()).collect(Collectors.toList());
    }

}
