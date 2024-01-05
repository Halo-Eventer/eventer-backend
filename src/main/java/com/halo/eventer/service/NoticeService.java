package com.halo.eventer.service;

import com.halo.eventer.dto.notice.NoticePageResDto;
import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.dto.notice.NoticeResDto;
import com.halo.eventer.dto.notice.PageInfo;
import com.halo.eventer.entity.Notice;
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

    @Transactional
    public NoticePageResDto inquireNoticeTitles(int page, int size) {
        Page<Notice> noticePages = noticeRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "updateTime")));

        PageInfo pageInfo = PageInfo.builder()
                .page(page)
                .pageSize(size)
                .totalPages(noticePages.getTotalPages())
                .totalNumber(noticePages.getTotalElements())
                .build();

        List<NoticeResDto> noticeInfos = noticePages.getContent()
                .stream().map(o->new NoticeResDto(o)).collect(Collectors.toList());  //noticePages에서 가져온 공지사항 정보를 NoticeResDto로 변환한 후, 리스트에 담기

        return NoticePageResDto.builder()
                .noticeInfos(noticeInfos)
                .pageInfo(pageInfo)
                .build();
    }

    @Transactional
    public Notice getNotice(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공지사항이 존재하지 않습니다."));

        return notice;
    }
}

