package com.blockpage.commentservice.domain;

import com.blockpage.commentservice.adaptor.infrastructure.entity.CommentEntity;
import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDomain {

    private Long commentId;
    private Long episodeId;
    private String parentsId;
    private String parentsNickname;
    private String childId;
    private String childNickname;
    private String content;
    private LocalDateTime dateTime;
    private int likesCount;
    private int dislikesCount;
    private int replyCount;
    private Boolean report;
    private Boolean erase;
    private Boolean pin;

    public static CommentDomain toDomainFrom(CommentQuery commentQuery) {
        return CommentDomain.builder()
            .commentId(commentQuery.getCommentId())
            .episodeId(commentQuery.getEpisodeId())
            .parentsId(commentQuery.getParentsId())
            .parentsNickname(commentQuery.getParentsNickname())
            .childId(commentQuery.getChildId())
            .childNickname(commentQuery.getChildNickname())
            .content(commentQuery.getContent())
            .likesCount(commentQuery.getLikesCount())
            .dislikesCount(commentQuery.getDislikesCount())
            .replyCount(commentQuery.getReplyCount())
            .report(commentQuery.getReport())
            .erase(commentQuery.getErase())
            .pin(commentQuery.getPin())
            .build();
    }

    public static CommentDomain toDomainFromId(Long commentId) {
        return CommentDomain.builder()
            .commentId(commentId)
            .build();
    }

    public static CommentDomain toDomainFromEntity(CommentEntity commentEntity){
        return CommentDomain.builder()
            .commentId(commentEntity.getId())
            .episodeId(commentEntity.getEpisodeId())
            .parentsId(commentEntity.getParentsId())
            .parentsNickname(commentEntity.getParentsNickname())
            .childId(commentEntity.getChildId())
            .childNickname(commentEntity.getChildNickname())
            .content(commentEntity.getContent())
            .dateTime(commentEntity.getUpdateTime())
            .likesCount(commentEntity.getLikesCount())
            .dislikesCount(commentEntity.getDislikesCount())
            .replyCount(commentEntity.getReplyCount())
            .report(commentEntity.getReport())
            .erase(commentEntity.getErase())
            .pin(commentEntity.getPin())
            .build();
    }

    public static List<CommentDomain> getComment(List<CommentDomain> commentDomain){
        return commentDomain.stream().filter(w -> !(w.getErase() && w.getReplyCount() == 0)).toList();
    }

}
