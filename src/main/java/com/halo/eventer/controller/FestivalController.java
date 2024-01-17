package com.halo.eventer.controller;


import com.halo.eventer.dto.festival.FestivalCreateDto;
import com.halo.eventer.service.FestivalService;
import com.halo.eventer.swagger.festival.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(festivalService.createFestival(festivalCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
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

    @GetHomeApi
    @GetMapping("/home/{festivalId}")
    public ResponseEntity<?> getBanner(@PathVariable("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(festivalService.getBanner(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
