package com.halo.eventer.dto.concert;

import com.halo.eventer.entity.Festival;
import com.halo.eventer.entity.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ConcertCreateDto {

    private String tag;

    private String name;

    private String summary;
    private String content;

    private double latitude; // 위도
    private double longitude; // 경도
    private String location;
    private Boolean isOperation;
    private String operationHours;

    private String thumbnail;

    private List<String> images;
}
