package com.halo.eventer.map.service;

import com.halo.eventer.common.StoreType;
import com.halo.eventer.map.dto.map.GetAllStoreResDto;
import com.halo.eventer.map.dto.map.StoreCreateDto;
import com.halo.eventer.map.dto.map.StoreCreateResDto;
import com.halo.eventer.map.dto.map.StoreResDto;
import com.halo.eventer.map.Store;
import com.halo.eventer.festival.repository.FestivalRepository;
import com.halo.eventer.image.ImageRepository;
import com.halo.eventer.map.repository.StoreRepository;
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
        if(storeCreateDto.getType().equals("MANAGER")){
            store.setType(StoreType.MANAGER);
        }
        else if (storeCreateDto.getType().equals("INFO")){
            store.setType(StoreType.INFO);
        }
        else if(storeCreateDto.getType().equals("SHOP")){
            store.setType(StoreType.SHOP);
        }
        else if(storeCreateDto.getType().equals("TOILET")){
            store.setType(StoreType.TOILET);
        }
        else if(storeCreateDto.getType().equals("SMOKING")){
            store.setType(StoreType.SMOKING);
        }
        else if(storeCreateDto.getType().equals("PARKING")){
            store.setType(StoreType.PARKING);
        }
        else{
            store.setType(StoreType.etc);
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
        if(storeCreateDto.getType().equals("MANAGER")){
            store.setType(StoreType.MANAGER);
        }
        else if (storeCreateDto.getType().equals("INFO")){
            store.setType(StoreType.INFO);
        }
        else if(storeCreateDto.getType().equals("SHOP")){
            store.setType(StoreType.SHOP);
        }
        else if(storeCreateDto.getType().equals("TOILET")){
            store.setType(StoreType.TOILET);
        }
        else if(storeCreateDto.getType().equals("SMOKING")){
            store.setType(StoreType.SMOKING);
        }
        else if(storeCreateDto.getType().equals("PARKING")){
            store.setType(StoreType.PARKING);
        }
        else{
            store.setType(StoreType.etc);
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
