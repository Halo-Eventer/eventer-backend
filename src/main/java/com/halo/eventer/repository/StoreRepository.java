package com.halo.eventer.repository;

import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Store;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAllByFestival(Festival festival);
}
