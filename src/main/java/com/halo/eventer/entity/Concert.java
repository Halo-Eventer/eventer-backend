package com.halo.eventer.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.halo.eventer.dto.concert.ConcertCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tag;

    private String name;

    private String summary;

    @Column(columnDefinition = "varchar(500)")
    private String content;

    private double latitude; // 위도
    private double longitude; // 경도
    private String location;

    private Boolean isOperation;
    private String operationHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    private String thumbnail;

    @OneToMany(mappedBy = "concert", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Image> images = new ArrayList<>();

    public Concert(ConcertCreateDto c) {
        this.tag = c.getTag();
        this.name = c.getName();
        this.summary = c.getSummary();
        this.content = c.getContent();
        this.latitude = c.getLatitude();
        this.longitude = c.getLongitude();
        this.location = c.getLocation();
        this.isOperation = c.getIsOperation();
        this.operationHours = c.getOperationHours();
        this.thumbnail = c.getThumbnail();
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}
