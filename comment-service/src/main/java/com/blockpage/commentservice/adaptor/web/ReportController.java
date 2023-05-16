package com.blockpage.commentservice.adaptor.web;

import com.blockpage.commentservice.adaptor.web.view.ApiResponseView;
import com.blockpage.commentservice.adaptor.web.view.ReportView;
import com.blockpage.commentservice.application.port.ReportDetailDto;
import com.blockpage.commentservice.application.port.in.CommentUseCase;
import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import com.blockpage.commentservice.application.port.in.ReportUseCase;
import com.blockpage.commentservice.application.port.in.ReportUseCase.ReportQuery;
import com.blockpage.commentservice.application.port.in.RequestReport;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reports")
public class ReportController {

    private final ReportUseCase reportUseCase;
    private final CommentUseCase commentUseCase;

    @PostMapping("")
    public ResponseEntity<ApiResponseView<String>> postRepost(@RequestBody RequestReport requestReport) {
        // 신고하는 서비스 로직 구현 해야함
        reportUseCase.saveReport(ReportQuery.toQueryFromRequest(requestReport));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseView<>("해당 댓글이 신고 되었습니다."));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponseView<List<ReportView>>> getReport(@RequestParam Long id) {

        List<ReportDetailDto> reportDetailDtoList = reportUseCase.getReport(ReportQuery.toQueryFromId(id));
        List<ReportView> reportViewList = reportDetailDtoList.stream().map(ReportView::toViewFromDto).toList();

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(reportViewList));
    }

    @PatchMapping
    public ResponseEntity<ApiResponseView<String>> acceptReport(@RequestBody RequestReport requestReport) {

        reportUseCase.solveReport(ReportQuery.toQueryFromRequest(requestReport));
        commentUseCase.reportComment(CommentQuery.toQueryFromId(requestReport.getCommentId()).getCommentId());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>("해당 댓글 신고처리가 승인되어, 삭제되어집니다."));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseView<String>> denyReport(@RequestBody RequestReport requestReport) {

        reportUseCase.solveReport(ReportQuery.toQueryFromRequest(requestReport));
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>("해당 댓글 신고처리가 거부되어, 삭제되어집니다."));
    }

}
