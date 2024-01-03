package com.halo.eventer.controller;

import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.dto.notice.NoticeResDto;
import com.halo.eventer.service.NoticeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "공지사항", description = "공지사항과 관련된 모든 것")
@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<?> registerNotice(@RequestBody NoticeReqDto noticeReqDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(noticeService.registerNotice(noticeReqDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
