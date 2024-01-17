package com.halo.eventer.dto.notice;

import com.halo.eventer.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@Schema(name = "이벤트 명단에 들어갈 이벤트 한개의 정보")
public class GetAllNoticeResDto {
    private String title;
    private String simpleExplanation;
    private String thumbnail;

    public GetAllNoticeResDto(Notice notice) {
        this.title = notice.getTitle();
        this.simpleExplanation = notice.getSimpleExplanation();
        this.thumbnail = notice.getThumbnail();
    }
}
