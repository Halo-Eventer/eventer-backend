package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GetAllNoticeResDto {

    private Long id;
    private String title;
    private String simpleExplanation;
    private String thumbnail;

    public GetAllNoticeResDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.simpleExplanation = notice.getSimpleExplanation();
        this.thumbnail = notice.getThumbnail();
    }
}
