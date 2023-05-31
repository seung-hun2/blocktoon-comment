package com.blockpage.commentservice.application.port;

import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import com.blockpage.commentservice.domain.CommentDomain;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveCommentDto {

    private Long episodeId;
    private Long commentId;
    private LocalDateTime dateTime;
    private String parentsId;
    private String parentsNickname;
    private String childId;
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

    public static SaveCommentDto toDtoFromDomain(CommentDomain commentDomain){
        return SaveCommentDto.builder()
            .episodeId(commentDomain.getEpisodeId())
            .commentId(commentDomain.getCommentId())
            .dateTime(commentDomain.getDateTime())
            .parentsId(commentDomain.getParentsId())
            .parentsNickname(commentDomain.getParentsNickname())
            .childId(commentDomain.getChildId())
            .childNickname(commentDomain.getChildNickname())
            .comment(commentDomain.getContent())
            .likesCount(commentDomain.getLikesCount())
            .dislikesCount(commentDomain.getDislikesCount())
            .replyCount(commentDomain.getReplyCount())
            .report(commentDomain.getReport())
            .erase(commentDomain.getErase())
            .pin(commentDomain.getPin())
            .build();
    }


}
