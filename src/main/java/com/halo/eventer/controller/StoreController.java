package com.halo.eventer.controller;



import com.halo.eventer.common.StoreType;
import com.halo.eventer.dto.store.StoreCreateDto;
import com.halo.eventer.service.StoreService;
import com.halo.eventer.swagger.festival.*;
import com.halo.eventer.swagger.store.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "상점")
@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
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
    @GetMapping("/{storeId}")
    public ResponseEntity<?> getStore(@PathVariable("storeId")Long id){
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
    @PatchMapping("/{storeId}")
    public ResponseEntity<?> updateStore(@PathVariable("storeId") Long id,
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
    @DeleteMapping("/{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable("storeId") Long id){
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
