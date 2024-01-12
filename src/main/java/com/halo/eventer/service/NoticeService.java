package com.halo.eventer.service;

import com.halo.eventer.dto.notice.*;
import com.halo.eventer.entity.Notice;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.DoubleStream.builder;

@Service
@AllArgsConstructor
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final FestivalRepository festivalRepository;

    @Transactional
    public NoticeResDto registerNotice(NoticeReqDto noticeReqDto) {
        Notice notice = Notice.builder()
                .id(noticeReqDto.getId())
                .title(noticeReqDto.getTitle())
                .simpleExplanation(noticeReqDto.getSimpleExplanation())
                .content(noticeReqDto.getContent())
                .updateTime(noticeReqDto.getUpdateTime())
                .festival(festivalRepository.findById(noticeReqDto.getFestivalId()).orElseThrow(() -> new NotFoundException(noticeReqDto.getFestivalId() + "에 해당하는 공지사항을 찾을 수 없습니다.")))
                .build();

        noticeRepository.save(notice);
        return NoticeResDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .simpleExplanation(notice.getSimpleExplanation())
                .content(notice.getContent())
                .updateTime(notice.getUpdateTime())
                .festivalId(notice.getFestival().getId())
                .build();
    }

    @Transactional
    public List<GetAllNoticeResDto> inquireNotices(Long festivalId) {
        List<Notice> notices = noticeRepository.findAllByFestival(festivalRepository.findById(festivalId)
                .orElseThrow(() -> new NotFoundException(festivalId + "에 해당하는 공지사항이 존재하지 않습니다.")));

        List<GetAllNoticeResDto> response = notices.stream()
                .map(o-> new GetAllNoticeResDto(o))
                .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public NoticeResDto getNotice(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공지사항이 존재하지 않습니다."));

        return NoticeResDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .simpleExplanation(notice.getSimpleExplanation())
                .content(notice.getContent())
                .updateTime(notice.getUpdateTime())
                .festivalId(notice.getFestival().getId())
                .build();
    }
}

