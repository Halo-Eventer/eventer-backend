package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Schema(name = "공지사항 정보")
public class NoticeResDto {
    @Schema(example = "1")
    private Long id;

    @Schema(example = "반입 금지 물품 안내")
    private String title;

    @Schema(example = "안전하고 편안한 무대 관람을 위한 반입 금지 물품을 숙지해주세요!")
    private String simpleExplanation;

    @Schema(example = "2023세종대학교 대동제 '해피세종데이' 무대 관람 구역 반입 금지 물품 안내")
    private String subtitle;

    @Schema(example = "새로운 바람, 밝은 달 안녕하세요, 세종대학교 제 36대..")
    private String content;

    @Schema(example = "2024-01-03T23:00:00")
    private LocalDateTime updateTime;


    private String image;

    public NoticeResDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.simpleExplanation = notice.getSimpleExplanation();
        this.subtitle = notice.getSubtitle();
        this.content = notice.getContent();
        this.updateTime = notice.getUpdateTime();
        this.image = notice.getImages().get(0).getImage_url();
        

    }
}

