package com.blockpage.commentservice.adaptor.web.view;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.application.port.ReportDetailDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class ReportView {

    private String memberId;
    private String memberNickname;
    private String content;
    private String reportDate;
    private ReportType reportType;


    public ReportView(String memberId, String memberNickname, String content, String reportDate, ReportType reportType) {
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.content = content;
        this.reportDate = reportDate;
        this.reportType = reportType;
    }

    public static ReportView toViewFromDto(ReportDetailDto reportDetailDto) {
        return new ReportView(
            reportDetailDto.getMemberId(),
            reportDetailDto.getMemberNickname(),
            reportDetailDto.getContent(),
            reportDetailDto.getReportDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
            reportDetailDto.getReportType()
        );
    }

}
