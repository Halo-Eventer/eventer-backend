package com.halo.eventer.controller;

import com.halo.eventer.dto.amenity.AmenityCreateDto;
import com.halo.eventer.service.AmenityService;
import com.halo.eventer.swagger.amenity.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "편의시설")
@RestController
@RequiredArgsConstructor
@RequestMapping("/amenity")
public class AmenityController {

    private final AmenityService amenityService;

    @CreateAmenityApi
    @PostMapping()
    public ResponseEntity<?> createAmenity(@RequestBody AmenityCreateDto amenityCreateDto,
                                           @RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(amenityService.createAmenity(amenityCreateDto, id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetAmenityApi
    @GetMapping("/{amenityId}")
    public ResponseEntity<?> getAmenity(@PathVariable("amenityId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(amenityService.getAmenity(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetAmenitiesApi
    @GetMapping()
    public ResponseEntity<?> getAmenities(@RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(amenityService.getAmenities(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @UpdateAmenityApi
    @PatchMapping("/{amenityId}")
    public ResponseEntity<?> updateAmenity(@PathVariable("amenityId") Long id,
                                           @RequestBody AmenityCreateDto amenityCreateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(amenityService.updateAmenity(id, amenityCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteAmenityApi
    @DeleteMapping("/{amenityId}")
    public ResponseEntity<?> deleteAmenity(@PathVariable("amenityId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(amenityService.deleteAmenity(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
