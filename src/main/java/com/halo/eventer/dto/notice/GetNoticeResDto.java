package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(name = "단일 공지사항 res 정보")
public class GetNoticeResDto {
    @Schema(example = "반입 금지 물품 안내")
    private String title;

    @Schema(example = "2023세종대학교 대동제 '해피세종데이' 무대 관람 구역 반입 금지 물품 안내")
    private String subtitle;

    @Schema(example = "새로운 바람, 밝은 달 안녕하세요, 세종대학교 제 36대..")
    private String content;

    private List<String> images;

    public GetNoticeResDto(Notice notice) {
        this.title = notice.getTitle();
        this.subtitle = notice.getSubtitle();
        this.content = notice.getContent();
    }

    public void setImages(List<Image> images){
        this.images = images.stream().map(o->o.getImage_url()).collect(Collectors.toList());
    }
}

