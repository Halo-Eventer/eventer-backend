package com.halo.eventer.dto;

import com.halo.eventer.dto.notice.BannerResDto;
import com.halo.eventer.dto.urgent.UrgentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class HomeDto {
    private List<BannerResDto> banner;
    private List<MissingPersonPopupDto> missingPerson;
    private List<UrgentDto> urgent;

    public HomeDto(List<BannerResDto> banner, List<MissingPersonPopupDto> missingPerson, List<UrgentDto> urgent) {
        this.banner = banner;
        this.missingPerson = missingPerson;
        this.urgent = urgent;
    }
}
