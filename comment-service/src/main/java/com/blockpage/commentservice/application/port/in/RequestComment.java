package com.blockpage.commentservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestComment {

    private Long episodeId;
    private Long parentsId;
    private String parentsNickname;
    private Long childId;
    private String childNickname;
    private String comment;
    private int likesCount;
    private int dislikesCount;
    private Boolean report;
    private Boolean erase;
    private Boolean pin;


}
