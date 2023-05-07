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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return ResponseEntity.status(HttpStatus.CREATED).body("해당 댓글이 신고 되었습니다.");
    }

    @GetMapping("")
    public ResponseEntity<ApiResponseView> reportList(@RequestParam Long memberId) {
        List<ReportView> reportViewList = new ArrayList<>();
        reportViewList.add(new ReportView(1L, "부적절한사람1", "노잼", Date.valueOf("2023-05-06"), ReportType.ABUSE));
        reportViewList.add(new ReportView(2L, "부적절한사람2", "진짜 노잼", Date.valueOf("2023-05-06"), ReportType.ABUSE));
        reportViewList.add(new ReportView(3L, "부적절한사람3", "매우 노잼", Date.valueOf("2023-05-06"), ReportType.ABUSE));

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(reportViewList));
    }

}
