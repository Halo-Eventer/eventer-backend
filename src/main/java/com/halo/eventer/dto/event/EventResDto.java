package com.halo.eventer.dto.event;


import com.halo.eventer.entity.Event;
import com.halo.eventer.entity.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class EventResDto {

    private String tag;

    private String name;

    private String summary;
    private String content;

    private String location;

    private Boolean isOperation;
    private String operationHours;

    private String thumbnail;
    private List<String> images;

    public EventResDto(Event e){
        this.tag = e.getTag();
        this.name = e.getName();
        this.summary = e.getSummary();
        this.content = e.getContent();
        this.location = e.getLocation();
        this.isOperation = e.getIsOperation();
        this.operationHours = e.getOperationHours();
        this.thumbnail = e.getThumbnail();
    }

    public void setImages(List<Image> images){
        this.images = images.stream().map(o->o.getImage_url()).collect(Collectors.toList());
    }

}
