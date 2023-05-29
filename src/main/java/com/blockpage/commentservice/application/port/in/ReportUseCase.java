package com.blockpage.commentservice.application.port.in;

import com.blockpage.commentservice.application.port.ReportDetailDto;
import com.blockpage.commentservice.application.port.SaveReportDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

public interface ReportUseCase {

    SaveReportDto saveReport(ReportQuery reportQuery);

    SaveReportDto solveReport(ReportQuery reportQuery);

    List<ReportDetailDto> getReport();

    @Getter
    @Builder
    class ReportQuery {

        String memberId;
        Long reportId;
        Long commentId;
        String memberNickname;
        String content;
        int reportType;

        public static ReportQuery toQueryFromRequest(RequestReport requestReport) {
            return ReportQuery.builder()
                .memberId(requestReport.getMemberId())
                .memberNickname(requestReport.getMemberNickname())
                .commentId(requestReport.getCommentId())
                .content(requestReport.getContent())
                .reportType(requestReport.getReportType())
                .build();
        }

        public static ReportQuery toQueryFromId(Long id) {
            return ReportQuery.builder()
                .reportId(id)
                .build();
        }
    }
}
