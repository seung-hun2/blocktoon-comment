package com.blockpage.commentservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestComment {

    private Long episodeId;
    private String content;
    private String nickname;
    private Long parentsCommentId;
    private String parentsId;
    private String parentsNickname;
    private String profileImage;
    private String profileSkin;

}
