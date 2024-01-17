package com.halo.eventer.dto.festival;


import com.halo.eventer.entity.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BannerResDto {
    private Long id;
    private String image;

    public BannerResDto(Notice n) {
        this.id = n.getId();
        this.image = n.getThumbnail();
    }
}
