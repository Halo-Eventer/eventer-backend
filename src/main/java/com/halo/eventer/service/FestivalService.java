package com.halo.eventer.service;


import com.halo.eventer.dto.festival.FestivalCreateDto;
import com.halo.eventer.dto.festival.FestivalResDto;
import com.halo.eventer.entity.Festival;
import com.halo.eventer.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class FestivalService {


    private final FestivalRepository festivalRepository;
    public String createFestival(FestivalCreateDto festivalCreateDto)throws Exception{
        if(festivalRepository.findByLocation(festivalCreateDto.getLocation()).isPresent()){
            throw new Exception("중복생성");

        }
        festivalRepository.save(Festival.builder().festivalCreateDto(festivalCreateDto)
                .build());
        return "저장완료";
    }

    public FestivalResDto getFestival(Long id)throws Exception{
        Festival festival = festivalRepository.findById(id).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        FestivalResDto response = new FestivalResDto(festival);
        return response;
    }

    @Transactional
    public FestivalResDto updateFestival(Long id, FestivalCreateDto festivalCreateDto) throws Exception{
        Festival festival = festivalRepository.findById(id).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        festival.setFestival(festivalCreateDto);
        FestivalResDto response = new FestivalResDto(festival);
        return response;
    }

    @Transactional
    public String deleteFestival(Long id) throws Exception{
        Festival festival = festivalRepository.findById(id).orElseThrow(()->new NotFoundException("존재하지 않습니다."));
        festivalRepository.delete(festival);
        return "삭제완료";
    }
}
