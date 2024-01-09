package com.halo.eventer.controller;



import com.halo.eventer.dto.booth.BoothCreateDto;
import com.halo.eventer.service.BoothService;
import com.halo.eventer.swagger.booth.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "부스")
@RestController
@RequiredArgsConstructor
@RequestMapping("/booth")
public class BoothController {
    private final BoothService boothService;


    @CreateBoothApi
    @PostMapping()
    public ResponseEntity<?> createBooth(@RequestBody BoothCreateDto boothCreateDto,
                                         @RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(boothService.createBooth(boothCreateDto, id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetBoothApi
    @GetMapping("/{boothId}")
    public ResponseEntity<?> getBooth(@PathVariable("boothId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(boothService.getBooth(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetBoothsApi
    @GetMapping()
    public ResponseEntity<?> getBooths(@RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(boothService.getBooths(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @UpdateBoothApi
    @PatchMapping("/{boothId}")
    public ResponseEntity<?> updateBooth(@PathVariable("boothId") Long id,
                                         @RequestBody BoothCreateDto boothCreateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(boothService.updateBooth(id, boothCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteBoothApi
    @DeleteMapping("/{boothId}")
    public ResponseEntity<?> deleteBooth(@PathVariable("boothId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(boothService.deleteBooth(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
