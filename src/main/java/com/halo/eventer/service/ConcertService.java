package com.halo.eventer.service;

import com.halo.eventer.dto.booth.GetAllBoothResDto;
import com.halo.eventer.dto.concert.ConcertCreateDto;
import com.halo.eventer.dto.concert.ConcertResDto;
import com.halo.eventer.dto.concert.GetAllConcertDto;

import com.halo.eventer.dto.notice.GetNoticeResDto;
import com.halo.eventer.entity.*;
import com.halo.eventer.repository.ConcertRepository;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;
    private final FestivalRepository festivalRepository;
    private final ImageRepository imageRepository;


    @Transactional
    public String registerConcert(ConcertCreateDto createDto, Long id) throws Exception {

        //TODO 중복 검사 어떻게?

        Festival festival =festivalRepository.findById(id).orElseThrow(()->new Exception("축제가 존재하지 않습니다."));
        Concert concert = new Concert(createDto);
        concert.setFestival(festival);

        concertRepository.save(concert);
        List<Image> images = createDto.getImages().stream().map(o-> new Image(o)).collect(Collectors.toList());

        images.stream().forEach((o)-> {
            o.setConcert(concert);
            imageRepository.save(o);
        });
        return "저장완료";
    }

    public List<GetAllConcertDto> getConcerts(Long festivalId) throws Exception {
        List<GetAllConcertDto> response = concertRepository.findAllByFestival(festivalRepository.findById(festivalId).orElseThrow(() -> new Exception("존재하지 않습니다.")))
                .stream().map(o -> new GetAllConcertDto(o)).collect(Collectors.toList());

        return response;
    }

    public ConcertResDto getConcert(Long id) {
        Concert concert = concertRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공연장이 존재하지 않습니다."));

        ConcertResDto response = new ConcertResDto(concert);
        response.setImages(concert.getImages());
        return response;
    }

    @Transactional
    public ConcertResDto updateConcert(Long concertId, ConcertCreateDto createDto) throws Exception {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new NotFoundException("존재하지 않습니다"));
        concert.setAll(createDto);

        concert.getImages().stream().forEach(o->imageRepository.delete(o));
        List<Image> images = createDto.getImages().stream().map(o-> new Image(o)).collect(Collectors.toList());

        images.stream().forEach((o)-> {
            o.setConcert(concert);
            imageRepository.save(o);
        });


        ConcertResDto response = new ConcertResDto(concert);
        response.setImages(images);

        return response;
    }

    @Transactional
    public String deleteEvent(Long eventId) throws Exception {
       Concert concert = concertRepository.findById(eventId).orElseThrow(() -> new NotFoundException("존재하지 않습니다."));
        concertRepository.delete(concert);
        return "삭제완료";
    }
}
