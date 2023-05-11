package com.blockpage.commentservice.application.port.in;

import com.blockpage.commentservice.application.port.SaveCommentDto;
import lombok.Builder;
import lombok.Getter;

public interface CommentUseCase {

    SaveCommentDto saveComment(CommentQuery commentQuery);

    @Getter
    @Builder
    class CommentQuery {

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

        public CommentQuery(Long episodeId, Long parentsId, String parentsNickname, Long childId, String childNickname, String comment,
            int likesCount, int dislikesCount, Boolean report, Boolean erase, Boolean pin) {
            this.episodeId = episodeId;
            this.parentsId = parentsId;
            this.parentsNickname = parentsNickname;
            this.childId = childId;
            this.childNickname = childNickname;
            this.comment = comment;
            this.likesCount = likesCount;
            this.dislikesCount = dislikesCount;
            this.report = report;
            this.erase = erase;
            this.pin = pin;
        }

        public static CommentQuery toQueryFromRequest(RequestComment requestComment){
            return CommentQuery.builder()
                .episodeId(requestComment.getEpisodeId())
                .parentsId(requestComment.getParentsId())
                .parentsNickname(requestComment.getParentsNickname())
                .childId(requestComment.getChildId())
                .childNickname(requestComment.getChildNickname())
                .comment(requestComment.getComment())
                .likesCount(requestComment.getLikesCount())
                .dislikesCount(requestComment.getDislikesCount())
                .report(false)
                .erase(false)
                .pin(false)
                .build();
        }
    }

}
