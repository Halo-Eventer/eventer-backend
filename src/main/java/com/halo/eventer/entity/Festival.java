package com.halo.eventer.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    private String image;

    private String location;

    @OneToMany(mappedBy = "festival", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Booth> booths = new ArrayList<>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Concert> concerts = new ArrayList<>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Amenity> amenities = new ArrayList<>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private ArrayList<Notice> notices = new ArrayList<>();


    public Festival(String name, String content, String image, String location) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.location = location;
    }
}
