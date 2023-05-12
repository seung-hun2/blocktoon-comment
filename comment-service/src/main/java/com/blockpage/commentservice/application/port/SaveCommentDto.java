package com.blockpage.commentservice.application.port;

import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveCommentDto {

    private Long episodeId;
    private Long parentsId;
    private String parentsNickname;
    private Long childId;
    private String childNickname;
    private String comment;
    private int likesCount;
    private int dislikesCount;
    private int replyCount;
    private Boolean report;
    private Boolean erase;
    private Boolean pin;

    public static SaveCommentDto toDtoFromQuery(CommentQuery commentQuery) {
        return SaveCommentDto.builder()
            .episodeId(commentQuery.getEpisodeId())
            .parentsId(commentQuery.getParentsId())
            .parentsNickname(commentQuery.getParentsNickname())
            .childId(commentQuery.getChildId())
            .childNickname(commentQuery.getChildNickname())
            .comment(commentQuery.getContent())
            .likesCount(commentQuery.getLikesCount())
            .dislikesCount(commentQuery.getDislikesCount())
            .replyCount(commentQuery.getReplyCount())
            .report(commentQuery.getReport())
            .erase(commentQuery.getErase())
            .pin(commentQuery.getPin())
            .build();
    }


}
