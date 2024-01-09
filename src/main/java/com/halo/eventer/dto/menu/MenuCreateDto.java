package com.halo.eventer.dto.menu;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuCreateDto {
    private String name;

    private Integer price;

    private String summary;

}
