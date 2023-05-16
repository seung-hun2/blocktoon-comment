package com.blockpage.commentservice.domain;

import com.blockpage.commentservice.adaptor.infrastructure.entity.ReportEntity;
import com.blockpage.commentservice.application.port.in.ReportUseCase.ReportQuery;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReportDomain {

    private Long memberId;
    private Long commentId;
    private ReportType reportType;
    private String memberNickname;
    private String content;
    private LocalDateTime reportDate;

    @Getter
    @AllArgsConstructor
    public enum ReportType{
        SPAM(0, "스팸/도배 신고"),
        PORNOGRAPHIC(1, "음란물 신고"),
        ABUSE(2, "욕설 신고"),
        ILLEGAL(3, "불법 정보 신고"),
        PRIVACY(4, "개인정보 노출 신고"),
        UNPLEASANT(5, "불쾌한 표현 신고");

        private int key;
        private String value;

        public static com.blockpage.commentservice.adaptor.infrastructure.value.ReportType findReportTypeByKey(int key) {
            return Arrays.stream(com.blockpage.commentservice.adaptor.infrastructure.value.ReportType.values())
                .filter(t -> t.getKey() == key)
                .findFirst().get();
        }
    }

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
            .reportType(findReportTypeByKey(reportQuery.getReportType()))
            .content(reportQuery.getContent())
            .build();
    }


    public static ReportDomain toDomainFromEntity(ReportEntity report) {
        return ReportDomain.builder()
            .commentId(report.getCommentId())
            .memberId(report.getMemberId())
            .memberNickname(report.getMemberNickname())
            .content(report.getContent())
            .reportDate(report.getRegisterTime())
            .reportType(findReportTypeByKey(report.getReportType().getKey()))
            .build();
    }

}
