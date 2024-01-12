package com.halo.eventer.repository;

import com.halo.eventer.entity.Image;
import com.halo.eventer.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
