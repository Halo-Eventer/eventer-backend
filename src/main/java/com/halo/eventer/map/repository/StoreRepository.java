package com.halo.eventer.map.repository;

import com.halo.eventer.common.StoreType;
import com.halo.eventer.festival.Festival;
import com.halo.eventer.map.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAllByFestivalAndType(Festival festival, StoreType type);
}
