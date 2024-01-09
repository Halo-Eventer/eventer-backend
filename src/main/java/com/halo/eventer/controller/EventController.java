package com.halo.eventer.controller;

import com.halo.eventer.dto.event.EventCreateDto;
import com.halo.eventer.service.EventService;
import com.halo.eventer.swagger.booth.DeleteBoothApi;
import com.halo.eventer.swagger.event.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "이벤트")
@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @CreateEventApi
    @PostMapping()
    public ResponseEntity<?> createEvent(@RequestBody EventCreateDto eventCreateDto,
                                         @RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(eventService.createEvent(eventCreateDto, id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetEventApi
    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEvent(@PathVariable("eventId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(eventService.getEvent(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetEventsApi
    @GetMapping()
    public ResponseEntity<?> getEvents(@RequestParam("festivalId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(eventService.getEvents(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @UpdateEventApi
    @PatchMapping("/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable("eventId") Long id,
                                         @RequestBody EventCreateDto eventCreateDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(eventService.updateEvent(id, eventCreateDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteEventApi
    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable("eventId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(eventService.deleteEvent(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}