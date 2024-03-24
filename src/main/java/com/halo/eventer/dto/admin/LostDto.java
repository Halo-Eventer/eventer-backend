package com.halo.eventer.dto.admin;


import com.halo.eventer.entity.LostItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LostDto {
    private String name;
    private String type;
    private String image;
    private String findDate;

    public LostDto(LostItem lostItem) {
        this.name = lostItem.getName();
        this.type = lostItem.getType();
        this.image = lostItem.getImage();
        this.findDate = lostItem.getFindDate();
    }
}
