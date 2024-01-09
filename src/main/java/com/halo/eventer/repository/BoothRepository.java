package com.halo.eventer.repository;

import com.halo.eventer.entity.Booth;
import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoothRepository extends JpaRepository<Booth, Long> {
    List<Booth> findAllByFestival(Festival festival);
}

