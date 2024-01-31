package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class GetNoticeResDto {

    private String title;
    private String thumbnail;
    private String subtitle;
    private String content;

    private List<String> images;

    public GetNoticeResDto(Notice notice) {
        this.title = notice.getTitle();
        this.thumbnail = notice.getThumbnail();
        this.subtitle = notice.getSubtitle();
        this.content = notice.getContent();
    }

    public void setImages(List<Image> images){
        this.images = images.stream().map(o->o.getImage_url()).collect(Collectors.toList());
    }
}

