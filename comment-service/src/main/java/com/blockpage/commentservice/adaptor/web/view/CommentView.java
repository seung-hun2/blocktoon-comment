package com.blockpage.commentservice.adaptor.web.view;

import lombok.Getter;

@Getter
public class CommentView {

    private Long episodeId;
    private Long parentsId;
    private String parentsNickname;
    private Long childId;
    private String childNickname;
    private String content;
    private int likesCount;
    private int dislikesCount;
    private int replyCount;
    private Boolean report;
    private Boolean erase;
    private Boolean pin;

    public CommentView(Long episodeId, Long parentsId, String parentsNickname, Long childId, String childNickname, String content,
        int likesCount, int dislikesCount, int replyCount, Boolean report, Boolean erase, Boolean pin) {
        this.episodeId = episodeId;
        this.parentsId = parentsId;
        this.parentsNickname = parentsNickname;
        this.childId = childId;
        this.childNickname = childNickname;
        this.content = content;
        this.likesCount = likesCount;
        this.dislikesCount = dislikesCount;
        this.replyCount = replyCount;
        this.report = report;
        this.erase = erase;
        this.pin = pin;
    }
}
