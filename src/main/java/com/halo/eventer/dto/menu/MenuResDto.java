package com.halo.eventer.dto.menu;

import com.halo.eventer.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuResDto {

    private String name;

    private Integer price;

    private String image;

    private String summary;

    public MenuResDto(Menu menu) {
        this.name = menu.getName();
        this.price = menu.getPrice();
        this.summary = menu.getSummary();
        this.image = menu.getImage();
    }
}
