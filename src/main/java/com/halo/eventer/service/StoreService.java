package com.halo.eventer.service;

import com.halo.eventer.common.StoreType;
import com.halo.eventer.dto.store.GetAllStoreResDto;
import com.halo.eventer.dto.store.StoreCreateDto;
import com.halo.eventer.dto.store.StoreCreateResDto;
import com.halo.eventer.dto.store.StoreResDto;
import com.halo.eventer.entity.Store;
import com.halo.eventer.repository.FestivalRepository;
import com.halo.eventer.repository.ImageRepository;
import com.halo.eventer.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final FestivalRepository festivalRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public StoreCreateResDto createStore(StoreCreateDto storeCreateDto, Long festivalId)throws Exception{
        //TODO:: 매장 중복 검사 어떻게?

        Store store = Store.builder().storeCreateDto(storeCreateDto)
                .build();



        store.setFestival(festivalRepository.findById(festivalId).orElseThrow(()-> new Exception("존재하지 않습니다.")));
        if(storeCreateDto.getType().equals("관리자")){
            store.setType(StoreType.관리자);
        }
        else if (storeCreateDto.getType().equals("관광안내소")){
            store.setType(StoreType.관광안내소);
        }
        else if(storeCreateDto.getType().equals("편의점")){
            store.setType(StoreType.편의점);
        }
        else if(storeCreateDto.getType().equals("화장실")){
            store.setType(StoreType.화장실);
        }
        else if(storeCreateDto.getType().equals("쓰레기통")){
            store.setType(StoreType.쓰레기통);
        }
        else if(storeCreateDto.getType().equals("흡연장")){
            store.setType(StoreType.흡연장);
        }
        else if(storeCreateDto.getType().equals("주차장")){
            store.setType(StoreType.주차장);
        }
        else{
            store.setType(StoreType.기타);
        }
        storeRepository.save(store);
        return new StoreCreateResDto(store.getId());
    }

    public StoreResDto getStore(Long storeId)throws Exception{
        Store store = storeRepository.findById(storeId).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        StoreResDto response = new StoreResDto(store);
        response.setMenus(store.getMenus());

        return response;
    }

    public List<GetAllStoreResDto> getStores(Long festivalId,StoreType type) throws Exception{
        
        List<GetAllStoreResDto> response = storeRepository.findAllByFestivalAndType(festivalRepository.findById(festivalId).orElseThrow(()->new Exception("존재하지 않습니다.")),type)
                .stream().map(o->new GetAllStoreResDto(o)).collect(Collectors.toList());

        return response;
    }

    @Transactional
    public StoreResDto updateStore(Long storeId, StoreCreateDto storeCreateDto) throws Exception{
        Store store = storeRepository.findById(storeId).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        store.setStore(storeCreateDto);
        if(storeCreateDto.getType().equals("관리자")){
            store.setType(StoreType.관리자);
        }
        else if (storeCreateDto.getType().equals("관광안내소")){
            store.setType(StoreType.관광안내소);
        }
        else if(storeCreateDto.getType().equals("편의점")){
            store.setType(StoreType.편의점);
        }
        else if(storeCreateDto.getType().equals("화장실")){
            store.setType(StoreType.화장실);
        }
        else if(storeCreateDto.getType().equals("쓰레기통")){
            store.setType(StoreType.쓰레기통);
        }
        else if(storeCreateDto.getType().equals("흡연장")){
            store.setType(StoreType.흡연장);
        }
        else if(storeCreateDto.getType().equals("주차장")){
            store.setType(StoreType.주차장);
        }
        else{
            store.setType(StoreType.기타);
        }
        StoreResDto response = new StoreResDto(store);

        return response;
    }

    @Transactional
    public String deleteStore(Long storeId) throws Exception{
        Store store = storeRepository.findById(storeId).orElseThrow(()->new NotFoundException("존재하지 않습니다."));
        storeRepository.delete(store);
        return "삭제완료";
    }
}
