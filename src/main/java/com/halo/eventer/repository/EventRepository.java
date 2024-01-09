package com.halo.eventer.repository;

import com.halo.eventer.entity.Event;
import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllByFestival(Festival festival);
}

