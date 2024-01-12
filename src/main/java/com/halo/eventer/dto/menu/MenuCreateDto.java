package com.halo.eventer.dto.menu;


import com.halo.eventer.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuCreateDto {
    private String name;

    private Integer price;

    private String summary;
    private String image;

}
