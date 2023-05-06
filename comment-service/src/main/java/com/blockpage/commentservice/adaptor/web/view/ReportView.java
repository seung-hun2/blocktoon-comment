package com.blockpage.commentservice.adaptor.web.view;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import java.sql.Date;
import lombok.Getter;

@Getter
public class ReportView {

    private Long memberId;
    private String memberNickname;
    private String content;
    private Date reportDate;

    public ReportView(Long memberId, String memberNickname, String content, Date reportDate, ReportType reportType) {
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.content = content;
        this.reportDate = reportDate;
        this.reportType = reportType;
    }

    private ReportType reportType;

}
