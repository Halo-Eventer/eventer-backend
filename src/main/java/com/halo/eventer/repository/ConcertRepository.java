package com.halo.eventer.repository;

import com.halo.eventer.entity.Amenity;
import com.halo.eventer.entity.Concert;
import com.halo.eventer.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findAllByFestival(Festival festival);

}
