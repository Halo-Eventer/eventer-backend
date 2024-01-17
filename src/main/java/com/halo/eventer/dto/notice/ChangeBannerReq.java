package com.halo.eventer.dto.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ChangeBannerReq {
    private List<Long> noticeIds;
}
