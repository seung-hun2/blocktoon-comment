package com.blockpage.commentservice.adaptor.web.view;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.application.port.ReportDetailDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class ReportView {

    private Long commentId;
    private String memberId;
    private String memberNickname;
    private String content;
    private String reportDate;
    private ReportType reportType;


    public ReportView(Long commentId, String memberId, String memberNickname, String content, String reportDate, ReportType reportType) {
        this.commentId = commentId;
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.content = content;
        this.reportDate = reportDate;
        this.reportType = reportType;
    }

    public static ReportView toViewFromDto(ReportDetailDto reportDetailDto) {
        return new ReportView(
            reportDetailDto.getCommentId(),
            reportDetailDto.getMemberId(),
            reportDetailDto.getMemberNickname(),
            reportDetailDto.getContent(),
            reportDetailDto.getReportDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
            reportDetailDto.getReportType()
        );
    }

}
