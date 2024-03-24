package com.halo.eventer.repository;

import com.halo.eventer.entity.MissingPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MissingPersonRepository extends JpaRepository<MissingPerson, Long> {
    List<MissingPerson> findAllByPopup(boolean b);
}
