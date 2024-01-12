package com.halo.eventer.controller;

import com.halo.eventer.dto.concert.ConcertCreateDto;
import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.entity.Concert;
import com.halo.eventer.service.ConcertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@Tag(name = "공연장", description = "공연장과 관련된 모든 것")
@RestController
@RequiredArgsConstructor
@RequestMapping("/concert")
public class ConcertController {

    private final ConcertService concertService;

    /**   공연장 생성하기   */
    @PostMapping
    public ResponseEntity<?> registerConcert (@RequestBody ConcertCreateDto createDto,
                                              @RequestParam("festivalId") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(concertService.registerConcert(createDto,id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAmenities(@RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(concertService.getConcerts(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @GetMapping("/{concert_id}")
    public ResponseEntity<?> getConcert(@PathVariable("concert_id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(concertService.getConcert(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
