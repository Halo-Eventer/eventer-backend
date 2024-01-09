package com.halo.eventer.repository;

import com.halo.eventer.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {


}
