package com.halo.eventer.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Image {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booth_id")
    private Booth booth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    public Image(String image_url) {
        this.image_url = image_url;
    }


    public void setBooth(Booth booth) {
        this.booth = booth;
    }

    public void setImage(String image_url) {
        this.image_url = image_url;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
