package com.blockpage.commentservice.domain;

import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDomain {

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

    public static CommentDomain toDomainFrom(CommentQuery commentQuery){
        return new CommentDomain(
            commentQuery.getEpisodeId(),
            commentQuery.getParentsId(),
            commentQuery.getParentsNickname(),
            commentQuery.getChildId(),
            commentQuery.getChildNickname(),
            commentQuery.getComment(),
            commentQuery.getLikesCount(),
            commentQuery.getDislikesCount(),
            commentQuery.getReport(),
            commentQuery.getErase(),
            commentQuery.getPin()
        );
    }

}
