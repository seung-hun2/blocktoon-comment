package com.blockpage.commentservice.adaptor.web.view;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.application.port.ReportDetailDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class ReportView {

    private String memberNickname;
    private String content;
    private LocalDateTime reportDate;
    private ReportType reportType;

    public ReportView(String memberNickname, String content, LocalDateTime reportDate, ReportType reportType) {
        this.memberNickname = memberNickname;
        this.content = content;
        this.reportDate = reportDate;
        this.reportType = reportType;
    }

    public static ReportView toViewFromDto(ReportDetailDto reportDetailDto) {
        return new ReportView(
            reportDetailDto.getMemberNickname(),
            reportDetailDto.getContent(),
            reportDetailDto.getReportDate(),
            reportDetailDto.getReportType()
        );
    }

}
