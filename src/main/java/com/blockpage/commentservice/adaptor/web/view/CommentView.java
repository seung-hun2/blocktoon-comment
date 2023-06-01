package com.blockpage.commentservice.adaptor.web.view;

import com.blockpage.commentservice.application.port.SaveCommentDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class CommentView {

    private Long episodeId;
    private Long commentId;
    private String dateTime;
    private String parentsId;
    private String parentsNickname;
    private String childId;
    private String childNickname;
    private String content;
    private int likesCount;
    private int dislikesCount;
    private int replyCount;
    private Boolean report;
    private Boolean erase;
    private Boolean pin;

    public CommentView(Long episodeId, Long commentId, String dateTime, String parentsId, String parentsNickname, String childId,
        String childNickname, String content,
        int likesCount, int dislikesCount, int replyCount, Boolean report, Boolean erase, Boolean pin) {
        this.episodeId = episodeId;
        this.commentId = commentId;
        this.dateTime = dateTime;
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

    public static CommentView toViewFromDto(SaveCommentDto saveCommentDto) {
        return new CommentView(saveCommentDto.getEpisodeId(),
            saveCommentDto.getCommentId(),
            saveCommentDto.getDateTime(),
            saveCommentDto.getParentsId(),
            saveCommentDto.getParentsNickname(),
            saveCommentDto.getChildId(),
            saveCommentDto.getChildNickname(),
            saveCommentDto.getComment(),
            saveCommentDto.getLikesCount(),
            saveCommentDto.getDislikesCount(),
            saveCommentDto.getReplyCount(),
            saveCommentDto.getReport(),
            saveCommentDto.getErase(),
            saveCommentDto.getPin());
    }
}
