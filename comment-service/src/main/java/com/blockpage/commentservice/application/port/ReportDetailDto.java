package com.blockpage.commentservice.application.port;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.domain.ReportDomain;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReportDetailDto {

    private String memberNickname;
    private String content;
    private LocalDateTime reportDate;
    private ReportType reportType;

    public static ReportDetailDto toDtoFromDomain(ReportDomain reportDomain) {
        return ReportDetailDto.builder()
            .memberNickname(reportDomain.getMemberNickname())
            .content(reportDomain.getContent())
            .reportDate(reportDomain.getReportDate())
            .reportType(ReportType.findReportTypeByKey(reportDomain.getReportType()))
            .build();
    }
}
