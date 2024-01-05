package com.halo.eventer.dto.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticePageResDto {
    private List<?> noticeInfos;
    private PageInfo pageInfo;
}
