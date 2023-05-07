package com.blockpage.commentservice.adaptor.web;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.adaptor.web.view.ApiResponseView;
import com.blockpage.commentservice.adaptor.web.view.ReportView;
import com.blockpage.commentservice.application.port.in.RequestReport;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/reports")
public class ReportController {
    @PostMapping("")
    public ResponseEntity report(@RequestBody RequestReport requestReport) {
        // 신고하는 서비스 로직 구현 해야함
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseView<>("해당 댓글이 신고 되었습니다."));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponseView> reportList(@RequestParam Long memberId) {
        List<ReportView> reportViewList = new ArrayList<>();
        reportViewList.add(new ReportView(1L, "부적절한사람1", "노잼", Date.valueOf("2023-05-06"), ReportType.ABUSE));
        reportViewList.add(new ReportView(2L, "부적절한사람2", "진짜 노잼", Date.valueOf("2023-05-06"), ReportType.ABUSE));
        reportViewList.add(new ReportView(3L, "부적절한사람3", "매우 노잼", Date.valueOf("2023-05-06"), ReportType.ABUSE));

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(reportViewList));
    }

    @PutMapping
    public ResponseEntity acceptReport(@RequestBody RequestReport requestReport){
        // 신고 승인되는 서비스 로직 구현해야함
        // 해당 댓글의 report ( true 로 변경 ), 해당 ReportEntity 삭제 해야함
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>("해당 댓글 신고처리가 승인되어, 삭제되어집니다."));
    }

    @DeleteMapping
    public ResponseEntity denyReport(@RequestBody RequestReport requestReport){
        // 신고 거부되는 서비스 로직 구현해야함
        // 해당 reportEntity 삭제
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>("해당 댓글 신고처리가 거부되어, 삭제되어집니다."));
    }

}
