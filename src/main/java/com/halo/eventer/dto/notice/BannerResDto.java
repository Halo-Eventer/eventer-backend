package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BannerResDto {
    private Long id;
    private String thumbnail;

    public BannerResDto(Notice n) {
        this.id = n.getId();
        this.thumbnail = n.getThumbnail();
    }
}
