package com.halo.eventer.service;


import com.halo.eventer.dto.booth.BoothCreateDto;
import com.halo.eventer.dto.booth.BoothResDto;
import com.halo.eventer.entity.Booth;
import com.halo.eventer.repository.BoothRepository;
import com.halo.eventer.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoothService {
    private final BoothRepository boothRepository;
    private final FestivalRepository festivalRepository;

    public String createBooth(BoothCreateDto boothCreateDto, Long festivalId)throws Exception{
        //TODO:: 편의시설 중복 검사 어떻게?

        Booth booth = new Booth(boothCreateDto);
        booth.setFestival(festivalRepository.findById(festivalId).orElseThrow(()-> new Exception("존재하지 않습니다.")));
        boothRepository.save(booth);
        return "저장완료";
    }

    public BoothResDto getBooth(Long boothId)throws Exception{
        Booth booth = boothRepository.findById(boothId).orElseThrow(()->new Exception("존재하지 않습니다."));
        return new BoothResDto(booth);
    }

    public List<BoothResDto> getBooths(Long festivalId) throws Exception {
        List<BoothResDto> response = boothRepository.findAllByFestival(festivalRepository.findById(festivalId).orElseThrow(() -> new Exception("존재하지 않습니다.")))
                .stream().map(o -> new BoothResDto(o)).collect(Collectors.toList());

        return response;
    }

    @Transactional
    public BoothResDto updateBooth(Long boothId, BoothCreateDto boothCreateDto) throws Exception {
        Booth booth = boothRepository.findById(boothId).orElseThrow(() -> new NotFoundException("존재하지 않습니다"));
        booth.setAll(boothCreateDto);
        return new BoothResDto(booth);
    }

    @Transactional
    public String deleteBooth(Long boothId) throws Exception {
        Booth booth = boothRepository.findById(boothId).orElseThrow(() -> new NotFoundException("존재하지 않습니다."));
        boothRepository.delete(booth);
        return "삭제완료";
    }

}
