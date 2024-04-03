package com.halo.eventer.festival.controller;


import com.halo.eventer.exception.DuplicatedElementException;
import com.halo.eventer.festival.dto.FestivalCreateDto;
import com.halo.eventer.festival.service.FestivalService;
import com.halo.eventer.festival.swagger.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/festival")
@Tag(name = "축제")
public class FestivalController {

    private final FestivalService festivalService;

    @CreateReqApi
    @CreateResApi
    @PostMapping()
    public ResponseEntity<?> createFestival(@RequestBody FestivalCreateDto festivalCreateDto){
        log.info("start\n");
        return ResponseEntity.status(HttpStatus.OK)
                .body(festivalService.createFestival(festivalCreateDto));
    }


    @GetResApi
    @GetReqApi
    @GetMapping("/{id}")
    public ResponseEntity<?> getFestival(@PathVariable("id")Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(festivalService.getFestival(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @UpdateResApi
    @UpdateReqApi
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateFestival(@PathVariable("id") Long id, @RequestBody FestivalCreateDto festivalCreateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(festivalService.updateFestival(id,festivalCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @DeleteResApi
    @DeleteReqAPi
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFestival(@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(festivalService.deleteFestival(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
