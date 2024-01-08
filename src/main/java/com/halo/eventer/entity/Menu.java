package com.halo.eventer.entity;


import com.halo.eventer.dto.Menu.MenuCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public Menu(MenuCreateDto menuCreateDto) {
        this.name = menuCreateDto.getName();
        this.price = menuCreateDto.getPrice();
        this.summary = menuCreateDto.getSummary();
    }

    public void setMenu(MenuCreateDto menuCreateDto) {
        this.name = menuCreateDto.getName();
        this.price = menuCreateDto.getPrice();
        this.summary = menuCreateDto.getSummary();
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
