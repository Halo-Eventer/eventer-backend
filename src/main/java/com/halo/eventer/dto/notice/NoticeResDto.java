package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Schema(name = "공지사항 정보")
public class NoticeResDto {

    @Schema(example = "주류 안내")
    private String title;

    @Schema(example = "모든 주류는 직접 구입해 주셔야 합니다.")
    private String content;

    @Schema(example = "2024-01-03T23:00:00")
    private LocalDateTime updateTime;

    private String image;
    public NoticeResDto(Notice notice) {
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.updateTime = notice.getUpdateTime();
        this.image = notice.getImages().get(0).getImage_url();
    }
}

