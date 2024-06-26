package com.halo.eventer.map.service;


import com.halo.eventer.map.dto.menu.MenuCreateDto;
import com.halo.eventer.map.dto.menu.MenuResDto;
import com.halo.eventer.map.Menu;
import com.halo.eventer.map.Store;
import com.halo.eventer.map.repository.MenuRepository;
import com.halo.eventer.map.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;
    public String createMenu(List<MenuCreateDto> menuCreateDtos, Long storeId)throws Exception{
        //TODO 중복 검사 어떻게?
        Store store =storeRepository.findById(storeId).orElseThrow(()->new Exception("상점이 존재하지 않습니다."));
        menuCreateDtos.stream().map(o->new Menu(o)).forEach(
                o ->{
                    o.setStore(store);
                    menuRepository.save(o);
                }
        );
        return "저장완료";
    }

    public List<MenuResDto> getMenus(Long storeId)throws Exception{
        Store store = storeRepository.findById(storeId).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        return store.getMenus().stream().map(o->new MenuResDto(o)).collect(Collectors.toList());
    }

    @Transactional
    public MenuResDto updateMenu(Long menuId, MenuCreateDto menuCreateDto) throws Exception{
        Menu menu = menuRepository.findById(menuId).orElseThrow(()->new NotFoundException("존재하지 않습니다"));
        menu.setMenu(menuCreateDto);
        return new MenuResDto(menu);
    }

    @Transactional
    public String deleteMenu(Long id) throws Exception{
        Menu menu = menuRepository.findById(id).orElseThrow(()->new NotFoundException("존재하지 않습니다."));
        menuRepository.delete(menu);
        return "삭제완료";
    }
}
