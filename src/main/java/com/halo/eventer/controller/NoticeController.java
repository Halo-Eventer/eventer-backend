package com.halo.eventer.controller;

import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.service.NoticeService;
import com.halo.eventer.swagger.notice.CreateNoticeReqApi;
import com.halo.eventer.swagger.notice.CreateNoticeResApi;
import com.halo.eventer.swagger.notice.GetNoticeReqApi;
import com.halo.eventer.swagger.notice.GetNoticeResApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.constraints.Min;

@Tag(name = "공지사항", description = "공지사항과 관련된 모든 것")
@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;


    /**   공지사항 생성하기   */
    @CreateNoticeReqApi
    @CreateNoticeResApi
    @PostMapping
    public ResponseEntity<?> registerNotice(@RequestBody NoticeReqDto noticeReqDto,
                                            @RequestParam("festivalId") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(noticeService.registerNotice(noticeReqDto,id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    /**   페이징 처리된 공지사항 제목들 조회하기   */
    @GetMapping()
    public ResponseEntity<?> inquireNoticeTitles(@RequestParam("festivalId") Long id,
                                                 @RequestParam("page") @Min(0) int page, // @Min(0) 어노테이션을 통해 이 값들이 0 이상이어야 한다는 제약을 걸어둠
                                                 @RequestParam("size") @Min(0) int size) {


        return ResponseEntity.status(HttpStatus.OK)
                .body(noticeService.inquireNotices(festivalId));
    }


    /**   공지사항 보여주기   */
    @GetNoticeReqApi
    @GetNoticeResApi
    @GetMapping("/{notice_id}")
    public ResponseEntity<?> getNotice(@PathVariable("notice_id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(noticeService.getNotice(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
