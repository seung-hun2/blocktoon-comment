package com.blockpage.commentservice.domain;

import com.blockpage.commentservice.adaptor.infrastructure.entity.CommentEntity;
import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDomain {

    private Long commentId;
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

    public static CommentDomain toDomainFrom(CommentQuery commentQuery) {
        return new CommentDomain(
            commentQuery.getCommentId(),
            commentQuery.getEpisodeId(),
            commentQuery.getParentsId(),
            commentQuery.getParentsNickname(),
            commentQuery.getChildId(),
            commentQuery.getChildNickname(),
            commentQuery.getContent(),
            commentQuery.getLikesCount(),
            commentQuery.getDislikesCount(),
            commentQuery.getReplyCount(),
            commentQuery.getReport(),
            commentQuery.getErase(),
            commentQuery.getPin()
        );
    }

    public static CommentDomain toDomainFromId(Long commentId) {
        return CommentDomain.builder()
            .commentId(commentId)
            .build();
    }

    public static CommentDomain toDomainFromEntity(CommentEntity commentEntity){
        return CommentDomain.builder()
            .episodeId(commentEntity.getEpisodeId())
            .parentsId(commentEntity.getParentsId())
            .parentsNickname(commentEntity.getParentsNickname())
            .childId(commentEntity.getChildId())
            .childNickname(commentEntity.getChildNickname())
            .content(commentEntity.getContent())
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
