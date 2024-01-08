package com.halo.eventer.controller;



import com.halo.eventer.dto.store.StoreCreateDto;
import com.halo.eventer.service.StoreService;
import com.halo.eventer.swagger.festival.*;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @CreateReqApi
    @CreateResApi
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


    @GetResApi
    @GetReqApi
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

    //@GetAllResApi
    //@GetAllReqApi
    @GetMapping()
    public ResponseEntity<?> getStores(@RequestParam("festivalId")Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(storeService.getStores(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @UpdateResApi
    @UpdateReqApi
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


    @DeleteResApi
    @DeleteReqAPi
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
