package com.blockpage.commentservice.application.port;

import com.blockpage.commentservice.application.port.in.ReportUseCase.ReportQuery;
import com.blockpage.commentservice.domain.ReportDomain;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveReportDto {

    Long memberId;
    Long reportId;
    int reportType;

    public static SaveReportDto toDtoFromQuery(ReportQuery reportQuery) {
        return new SaveReportDto(
            reportQuery.getMemberId(),
            reportQuery.getReportId(),
            reportQuery.getReportType()
        );
    }

    public static SaveReportDto toDtoFromDomain(ReportDomain reportDomain) {
        return new SaveReportDto(
            reportDomain.getMemberId(),
            reportDomain.getMemberId(),
            reportDomain.getReportType()
        );
    }

}
