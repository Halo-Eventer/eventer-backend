package com.halo.eventer.dto.notice;


import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class GetOneNoticeDto {

    private String title;

    private String simpleExplanation;

    private LocalDateTime updateTime;

    private List<String> images;

    public GetOneNoticeDto(Notice n) {
        this.title = n.getTitle();
        this.simpleExplanation = n.getSimpleExplanation();
        this.updateTime = n.getUpdateTime();
    }
    public void setImages(List<Image> images){
        this.images = images.stream().map(o->o.getImage_url()).collect(Collectors.toList());
    }
}
