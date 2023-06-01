package com.blockpage.commentservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestComment {

    private Long episodeId;
    private String content;
    private String nickname;
    private String parentsId;
    private String parentsNickname;

}
