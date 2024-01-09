package com.halo.eventer.dto.concert;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Schema(name = "공연장 정보")
public class ConcertResDto {

    @Schema(example = "공연장")
    private String tag;

    @Schema(example = "메인 공연장")
    private String name;

    @Schema(example = "소수빈, IVE, 10CM 공연")
    private String summary;

    @Schema(example = "학교 중앙 운동장")
    private String location;

    private Boolean isOperation;

    private LocalDateTime openingTime;

    private LocalDateTime closingTime;

    private LocalDateTime useTime;
}
