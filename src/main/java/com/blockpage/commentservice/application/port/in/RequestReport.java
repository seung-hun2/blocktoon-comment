package com.blockpage.commentservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestReport {

    private String memberId;
    private Long commentId;
    private String memberNickname;
    private String content;
    private int reportType;

}
