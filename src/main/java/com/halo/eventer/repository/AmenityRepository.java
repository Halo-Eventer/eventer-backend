package com.halo.eventer.repository;

import com.halo.eventer.entity.Amenity;
import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity,Long> {
    List<Amenity> findAllByFestival(Festival festival);
}

