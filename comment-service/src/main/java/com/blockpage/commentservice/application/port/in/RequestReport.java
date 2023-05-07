package com.blockpage.commentservice.application.port.in;

import java.sql.Date;
import lombok.Getter;

@Getter
public class RequestReport {

    private Long memberId;
    private String memberNickname;
    private String content;
    private Date reportDate;
    private String reportType;

}
