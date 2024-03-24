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
    @JoinColumn(name = "concert_id")
    private Concert concert;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;
    public Image(String image_url) {
        this.image_url = image_url;
    }


    public void setBooth(Booth booth) {
        this.booth = booth;
    }

    public void setImage(String image_url) {
        this.image_url = image_url;
    }


    public void setConcert(Concert concert) {
        this.concert = concert;
    }
    public  void setNotice(Notice notice){
        this.notice = notice;
    }
}
