package com.blockpage.commentservice.domain;

import com.blockpage.commentservice.adaptor.infrastructure.entity.ReportEntity;
import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.application.port.in.ReportUseCase.ReportQuery;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReportDomain {

    private Long memberId;
    private Long commentId;
    private int reportType;
    private String memberNickname;
    private String content;
    private LocalDateTime reportDate;

    public static ReportType findReportTypeByKey(int key) {
        return Arrays.stream(ReportType.values())
            .filter(t -> t.getKey() == key)
            .findFirst().get();
    }

    public static ReportDomain toDomainFromQuery(ReportQuery reportQuery) {
        return ReportDomain.builder()
            .commentId(reportQuery.getCommentId())
            .memberId(reportQuery.getMemberId())
            .memberNickname(reportQuery.getMemberNickname())
            .reportType(reportQuery.getReportType())
            .content(reportQuery.getContent())
            .build();
    }


    public static ReportDomain toDomainFromEntity(ReportEntity report) {
        ReportType reportType1 = report.getReportType();

        int rt = 0;
        if (reportType1 == ReportType.PORNOGRAPHIC) {
            rt = 1;
        }
        if (reportType1 == ReportType.ABUSE) {
            rt = 2;
        }
        if (reportType1 == ReportType.ILLEGAL) {
            rt = 3;
        }
        if (reportType1 == ReportType.PRIVACY) {
            rt = 4;
        }
        if (reportType1 == ReportType.UNPLEASANT) {
            rt = 5;
        }

        return ReportDomain.builder()
            .commentId(report.getCommentId())
            .memberId(report.getMemberId())
            .memberNickname(report.getMemberNickname())
            .content(report.getContent())
            .reportDate(report.getRegisterTime())
            .reportType(rt)
            .build();
    }

}
