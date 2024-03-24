package com.halo.eventer.dto.urgent;


import com.halo.eventer.entity.Urgent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UrgentDto {

    private String title;
    private String content;

    public UrgentDto(Urgent u) {
        this.title = u.getTitle();
        this.content = u.getContent();
    }
}
