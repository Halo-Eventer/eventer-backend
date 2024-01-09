package com.halo.eventer.service;


import com.halo.eventer.dto.booth.BoothCreateDto;
import com.halo.eventer.dto.booth.BoothResDto;
import com.halo.eventer.dto.event.EventCreateDto;
import com.halo.eventer.dto.event.EventResDto;
import com.halo.eventer.entity.Booth;
import com.halo.eventer.entity.Event;
import com.halo.eventer.repository.BoothRepository;
import com.halo.eventer.repository.EventRepository;
import com.halo.eventer.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final FestivalRepository festivalRepository;

    public String createEvent(EventCreateDto eventCreateDto, Long festivalId) throws Exception {
        //TODO:: 이벤트 중복 검사 어떻게?

        Event event = new Event(eventCreateDto);
        event.setFestival(festivalRepository.findById(festivalId).orElseThrow(() -> new Exception("존재하지 않습니다.")));
        eventRepository.save(event);
        return "저장완료";
    }

    public EventResDto getEvent(Long eventId) throws Exception {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new Exception("존재하지 않습니다."));
        return new EventResDto(event);
    }

    public List<EventResDto> getEvents(Long festivalId) throws Exception {
        List<EventResDto> response = eventRepository
                .findAllByFestival(festivalRepository.findById(festivalId).orElseThrow(() -> new Exception("존재하지 않습니다.")))
                .stream().map(o -> new EventResDto(o)).collect(Collectors.toList());

        return response;
    }

    @Transactional
    public EventResDto updateEvent(Long eventId, EventCreateDto eventCreateDto) throws Exception {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new NotFoundException("존재하지 않습니다"));
        event.setAll(eventCreateDto);
        return new EventResDto(event);
    }

    @Transactional
    public String deleteEvent(Long eventId) throws Exception {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new NotFoundException("존재하지 않습니다."));
        eventRepository.delete(event);
        return "삭제완료";
    }
}
