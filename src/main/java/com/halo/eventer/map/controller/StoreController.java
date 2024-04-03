package com.halo.eventer.map.controller;



import com.halo.eventer.common.StoreType;
import com.halo.eventer.map.dto.map.StoreCreateDto;
import com.halo.eventer.map.service.StoreService;
import com.halo.eventer.map.swagger.store.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "지도 카테고리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/mapCategory")
public class StoreController {
    private final StoreService storeService;

    @CreateStoreReqApi
    @CreateStoreResApi
    @PostMapping()
    public ResponseEntity<?> createStore(@RequestBody StoreCreateDto storeCreateDto,
                                         @RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(storeService.createStore(storeCreateDto,id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @GetStoreApi
    @GetMapping("/{mapId}")
    public ResponseEntity<?> getStore(@PathVariable("mapId")Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(storeService.getStore(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetStoresApi
    @GetMapping()
    public ResponseEntity<?> getStores(@RequestParam("festivalId")Long id,
                                       @RequestParam("type") StoreType type){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(storeService.getStores(id,type));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @UpdateStoreApi
    @PatchMapping("/{mapId}")
    public ResponseEntity<?> updateStore(@PathVariable("mapId") Long id,
                                         @RequestBody StoreCreateDto storeCreateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(storeService.updateStore(id, storeCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @DeleteStoreApi
    @DeleteMapping("/{mapId}")
    public ResponseEntity<?> deleteStore(@PathVariable("mapId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(storeService.deleteStore(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
