package com.halo.eventer.controller;

import com.halo.eventer.dto.menu.MenuCreateDto;
import com.halo.eventer.service.MenuService;
import com.halo.eventer.swagger.menu.CreateMenuAPi;
import com.halo.eventer.swagger.menu.DeleteMenuApi;
import com.halo.eventer.swagger.menu.GetMenusApi;
import com.halo.eventer.swagger.menu.UpdateMenuApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "메뉴")
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;


    @CreateMenuAPi
    @PostMapping()
    public ResponseEntity<?> createMenu(@RequestBody MenuCreateDto menuCreateDto,
                                        @RequestParam("storeId")Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(menuService.createMenu(menuCreateDto, id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMenusApi
    @GetMapping()
    public ResponseEntity<?> getMenus(@RequestParam("storeId")Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(menuService.getMenus(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @UpdateMenuApi
    @PatchMapping("/{menuId}")
    public ResponseEntity<?> updateMenu(@PathVariable("menuId") Long id,
                                        @RequestBody MenuCreateDto menuCreateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(menuService.updateMenu(id, menuCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @DeleteMenuApi
    @DeleteMapping("/{menuId}")
    public ResponseEntity<?> deleteMenu(@PathVariable("menuId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(menuService.deleteMenu(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
