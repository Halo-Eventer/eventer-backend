package com.halo.eventer.service;


import com.halo.eventer.dto.notice.*;
import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Notice;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.ImageRepository;
import com.halo.eventer.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final FestivalRepository festivalRepository;

    private final ImageRepository imageRepository;

    @Transactional
    public String registerNotice(NoticeReqDto noticeReqDto, Long id) throws Exception {

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
    public List<GetAllNoticeResDto> inquireNotices(Long festivalId) {
        List<Notice> notices = noticeRepository.findAllByFestival(festivalRepository.findById(festivalId)
                .orElseThrow(() -> new NotFoundException(festivalId + "에 해당하는 공지사항이 존재하지 않습니다.")));

        List<GetAllNoticeResDto> response = notices.stream()
                .map(o-> new GetAllNoticeResDto(o))
                .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public GetNoticeResDto getNotice(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공지사항이 존재하지 않습니다."));

        GetNoticeResDto response = new GetNoticeResDto(notice);
        response.setImages(notice.getImages());

        return response;


    }

    @Transactional
    public String changeBanner(ChangeBannerReq changeBannerReq, Long id) throws Exception{
        List<Notice> notices = noticeRepository.findAllByFestival(festivalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공지사항이 존재하지 않습니다.")));
        int i =0;
        for(Notice n : notices){
            if(n.getId() == changeBannerReq.getNoticeIds().get(i)){
                n.setPicked(true);
                i++;
            }
            else{
                n.setPicked(false);
            }
            if(changeBannerReq.getNoticeIds().size() == i){
                break;
            }
        }
        return "배너 등록";
    }
}

