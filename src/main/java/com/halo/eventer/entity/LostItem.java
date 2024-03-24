package com.halo.eventer.entity;


import com.halo.eventer.dto.admin.LostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Entity
@NoArgsConstructor
public class LostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String findDate;

    private String type;

    public LostItem(LostDto lostDto) {
        this.name = lostDto.getName();
        this.image = lostDto.getImage();
        this.findDate = lostDto.getFindDate();
        this.type = lostDto.getType();
    }

    public void updateItem(LostDto lostDto) {
        this.name = lostDto.getName();
        this.image = lostDto.getImage();
        this.findDate = lostDto.getFindDate();
        this.type = lostDto.getType();
    }
}
