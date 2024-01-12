package com.halo.eventer.service;


import com.halo.eventer.dto.booth.BoothCreateDto;
import com.halo.eventer.dto.booth.BoothResDto;
import com.halo.eventer.dto.booth.GetAllBoothResDto;
import com.halo.eventer.entity.Booth;
import com.halo.eventer.entity.Image;
import com.halo.eventer.repository.BoothRepository;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.ImageRepository;
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
    private final ImageRepository imageRepository;

    public String createBooth(BoothCreateDto boothCreateDto, Long festivalId)throws Exception{
        //TODO:: 편의시설 중복 검사 어떻게?

        Booth booth = new Booth(boothCreateDto);
        booth.setFestival(festivalRepository.findById(festivalId).orElseThrow(()-> new Exception("존재하지 않습니다.")));
        boothRepository.save(booth);
        List<Image> images = boothCreateDto.getImages().stream().map(o-> new Image(o)).collect(Collectors.toList());

        images.stream().forEach((o)-> {
            o.setBooth(booth);
            imageRepository.save(o);
        });
        return "저장완료";
    }

    public BoothResDto getBooth(Long boothId)throws Exception{
        Booth booth = boothRepository.findById(boothId).orElseThrow(()->new Exception("존재하지 않습니다."));
        BoothResDto response = new BoothResDto(booth);
        response.setImages(booth.getImages());
        return response;
    }

    public List<GetAllBoothResDto> getBooths(Long festivalId) throws Exception {
        List<GetAllBoothResDto> response = boothRepository.findAllByFestival(festivalRepository.findById(festivalId).orElseThrow(() -> new Exception("존재하지 않습니다.")))
                .stream().map(o -> new GetAllBoothResDto(o)).collect(Collectors.toList());

        return response;
    }

    @Transactional
    public BoothResDto updateBooth(Long boothId, BoothCreateDto boothCreateDto) throws Exception {
        Booth booth = boothRepository.findById(boothId).orElseThrow(() -> new NotFoundException("존재하지 않습니다"));
        booth.setAll(boothCreateDto);

        //TODO: 이미지 수정 로직 필요

        return new BoothResDto(booth);
    }

    @Transactional
    public String deleteBooth(Long boothId) throws Exception {
        Booth booth = boothRepository.findById(boothId).orElseThrow(() -> new NotFoundException("존재하지 않습니다."));
        boothRepository.delete(booth);
        return "삭제완료";
    }

}
