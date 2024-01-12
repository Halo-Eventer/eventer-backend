package com.halo.eventer.dto.concert;

import com.halo.eventer.entity.Concert;
import com.halo.eventer.entity.Image;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Schema(name = "공연장 정보")
public class ConcertResDto {

    @Schema(example = "공연장")
    private String tag;

    @Schema(example = "메인 공연장")
    private String name;

    @Schema(example = "소수빈, IVE, 10CM 공연")
    private String summary;

    private String content;

    @Schema(example = "학교 중앙 운동장")
    private String location;

    private Boolean isOperation;

    private String operationHours;
    private String thumbnail;

    private List<String> images;

    public ConcertResDto(Concert c) {
        this.tag = c.getTag();
        this.name = c.getName();
        this.summary = c.getSummary();
        this.content = c.getContent();
        this.location = c.getLocation();
        this.isOperation = c.getIsOperation();
        this.operationHours = c.getOperationHours();
        this.thumbnail = c.getThumbnail();
    }

    public void setImages(List<Image> images){
        this.images = images.stream().map(o->o.getImage_url()).collect(Collectors.toList());
    }
}
