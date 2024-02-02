package com.halo.eventer.controller;

import com.halo.eventer.dto.notice.ChangeBannerReq;
import com.halo.eventer.dto.notice.NoticeReqDto;
import com.halo.eventer.service.NoticeService;
import com.halo.eventer.swagger.notice.*;
import com.halo.eventer.swagger.store.DeleteStoreApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

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


    /**   공지사항 리스트 조회하기   */
    @GetNoticesReqApi
    @GetNoticesResApi
    @GetMapping("/{festivalId}/list")
    public ResponseEntity<?> inquireNotices(@PathVariable Long festivalId) {

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(noticeService.inquireNotices(festivalId));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    /**   단일 공지사항 조회하기   */
    @GetNoticeReqApi
    @GetNoticeResApi
    @GetMapping("/{noticeId}")
    public ResponseEntity<?> getNotice(@PathVariable("noticeId") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(noticeService.getNotice(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @SelectBannerApi
    @PostMapping("/banner/{festivalId}")
    public ResponseEntity<?> changeBanner(@RequestBody ChangeBannerReq changeBannerReq,
                                          @PathVariable("festivalId") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(noticeService.changeBanner(changeBannerReq,id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/{noticeId}")
    public ResponseEntity<?> updateNotice(@PathVariable("noticeId") Long id,
                                          @RequestBody NoticeReqDto noticeReqDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(noticeService.updateNotice(id,noticeReqDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }



    @DeleteMapping("/{noticeId}")
    public ResponseEntity<?> deleteNotice(@PathVariable("noticeId") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(noticeService.deleteNotice(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
