package com.halo.eventer.service;

import com.halo.eventer.common.StoreType;
import com.halo.eventer.dto.amenity.AmenityCreateDto;
import com.halo.eventer.dto.amenity.AmenityResDto;
import com.halo.eventer.dto.amenity.GetAllAmenityResDto;
import com.halo.eventer.dto.store.GetAllStoreResDto;
import com.halo.eventer.dto.store.StoreCreateDto;
import com.halo.eventer.dto.store.StoreResDto;
import com.halo.eventer.entity.Amenity;
import com.halo.eventer.entity.Store;
import com.halo.eventer.repository.AmenityRepository;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;
    private final FestivalRepository festivalRepository;

    public String createAmenity(AmenityCreateDto amenityCreateDto, Long festivalId)throws Exception{
        //TODO:: 편의시설 중복 검사 어떻게?

        Amenity amenity = new Amenity(amenityCreateDto);
        amenity.setFestival(festivalRepository.findById(festivalId).orElseThrow(()-> new Exception("존재하지 않습니다.")));
        amenityRepository.save(amenity);
        return "저장완료";
    }

    public AmenityResDto getAmenity(Long amenityId)throws Exception{
        Amenity amenity = amenityRepository.findById(amenityId).orElseThrow(()->new Exception("존재하지 않습니다."));
        return new AmenityResDto(amenity);
    }

    public List<GetAllAmenityResDto> getAmenities(Long festivalId) throws Exception{
        List<GetAllAmenityResDto> response = amenityRepository.findAllByFestival(festivalRepository.findById(festivalId).orElseThrow(()->new Exception("존재하지 않습니다.")))
                .stream().map(o->new GetAllAmenityResDto(o)).collect(Collectors.toList());

        return response;
    }

    @Transactional
    public AmenityResDto updateAmenity(Long amenityId, AmenityCreateDto amenityCreateDto) throws Exception{
        Amenity amenity = amenityRepository.findById(amenityId).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        amenity.setAll(amenityCreateDto);
        return new AmenityResDto(amenity);
    }

    @Transactional
    public String deleteAmenity(Long amenityId) throws Exception{
        Amenity amenity = amenityRepository.findById(amenityId).orElseThrow(()->new NotFoundException("존재하지 않습니다."));
        amenityRepository.delete(amenity);
        return "삭제완료";
    }
}
