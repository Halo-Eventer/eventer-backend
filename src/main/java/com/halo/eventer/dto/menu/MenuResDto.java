package com.halo.eventer.dto.menu;

import com.halo.eventer.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuResDto {
    private Long id;

    private String name;

    private Integer price;

    private String summary;

    public MenuResDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.price = menu.getPrice();
        this.summary = menu.getSummary();
    }
}
