package com.halo.eventer.repository;

import com.halo.eventer.entity.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
}
