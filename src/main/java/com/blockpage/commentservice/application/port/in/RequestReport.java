package com.blockpage.commentservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestReport {

    private Long memberId;
    private Long commentId;
    private String memberNickname;
    private String content;
    private int reportType;

}
