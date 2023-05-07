package com.blockpage.commentservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestComment {

    private Long episodeId;
    private Long parentsId;
    private String parentsNickname;
    private Long childId;
    private Long childNickname;
    private String comment;
}
