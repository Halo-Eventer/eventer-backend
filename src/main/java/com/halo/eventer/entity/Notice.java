package com.halo.eventer.entity;

import com.halo.eventer.dto.notice.NoticeReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "notice", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Image> images = new ArrayList<>();

    @LastModifiedDate
    private LocalDateTime updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    public Notice(NoticeReqDto n) {
        this.title = n.getTitle();
        this.content = n.getContent();
    }


    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}
