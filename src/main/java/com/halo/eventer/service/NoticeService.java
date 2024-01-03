package com.halo.eventer.service;

import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.dto.notice.NoticeResDto;
import com.halo.eventer.entity.Notice;
import com.halo.eventer.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public NoticeResDto registerNotice(NoticeReqDto noticeReqDto) {
        Notice notice = Notice.builder()
                .title(noticeReqDto.getTitle())
                .content(noticeReqDto.getContent())
                .updateTime(noticeReqDto.getUpdateTime())
                .build();

        noticeRepository.save(notice);
        return NoticeResDto.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .updateTime(notice.getUpdateTime())
                .build();
    }
}

