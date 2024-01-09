package com.halo.eventer.service;

import com.halo.eventer.dto.concert.ConcertResDto;
import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.dto.notice.NoticeResDto;
import com.halo.eventer.entity.Concert;
import com.halo.eventer.entity.Notice;
import com.halo.eventer.repository.ConcertRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class ConcertService {

    private final ConcertRepository concertRepository;


    @Transactional
    public ConcertResDto registerConcert(Concert concert) {

        concertRepository.save(concert);

        return ConcertResDto.builder()
                .tag(concert.getTag())
                .name(concert.getName())
                .summary(concert.getSummary())
                .location(concert.getLocation())
                .isOperation(concert.getIsOperation())
                .openingTime(concert.getOpeningTime())
                .closingTime(concert.getClosingTime())
                .useTime(concert.getUseTime())
                .build();
    }

    @Transactional
    public Concert getConcert(Long id) {
        Concert concert = concertRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공연장이 존재하지 않습니다."));

        return concert;
    }



//    /**   공연장 정보 가져오기   */
//    @Transactional
//    public ConcertResDto getConcert(Long id) {
//        Concert concert = concertRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException(id + "에 해당하는 공연장이 존재하지 않습니다."));
//
//        Boolean isOperation =  updateConcertStatus(concert);
//
//        return ConcertResDto.builder()
//                .tag(concert.getTag())
//                .name(concert.getName())
//                .summary(concert.getSummary())
//                .location(concert.getLocation())
//                .isOperation(isOperation)
//                .openingTime(concert.getOpeningTime())
//                .closingTime(concert.getClosingTime())
//                .useTime(concert.getUseTime())
//                .build();
//    }

    /**   isOperation 업데이트   */
    public Boolean updateConcertStatus(Concert concert) {
        LocalDateTime useTime = concert.getUseTime();
        LocalDateTime openingTime = concert.getOpeningTime();
        LocalDateTime closingTime = concert.getClosingTime();

        boolean isOperation = isWithinOperationHours(useTime, openingTime, closingTime);
        return isOperation;
    }

    /**   isOperation Boolean 값 확인하기   */
    public boolean isWithinOperationHours(LocalDateTime useTime, LocalDateTime openingTime, LocalDateTime closingTime) {

        return !useTime.isBefore(openingTime) && !useTime.isAfter(closingTime);
    }
}
