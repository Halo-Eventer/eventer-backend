package com.halo.eventer.service;

import com.amazonaws.services.kms.model.ExpiredImportTokenException;
import com.halo.eventer.dto.notice.*;
import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Notice;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.ImageRepository;
import com.halo.eventer.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final FestivalRepository festivalRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public String registerNotice(NoticeReqDto noticeReqDto, Long id)throws Exception {

        Festival festival = festivalRepository.findById(id).orElseThrow(()-> new Exception("축제가 존재하지 않습니다."));

        Notice notice = new Notice(noticeReqDto);
        notice.setFestival(festival);
        noticeRepository.save(notice);
        List<Image> images = noticeReqDto.getImages().stream().map(o-> new Image(o)).collect(Collectors.toList());

        images.stream().forEach((o)-> {
            o.setNotice(notice);
            imageRepository.save(o);
        });
        return "저장 완료";
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
    public GetOneNoticeDto getNotice(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공지사항이 존재하지 않습니다."));

        GetOneNoticeDto response = new GetOneNoticeDto(notice);
        response.setImages(notice.getImages());

        return response;
    }
}

