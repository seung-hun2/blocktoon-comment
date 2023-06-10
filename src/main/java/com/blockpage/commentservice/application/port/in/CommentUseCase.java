package com.blockpage.commentservice.application.port.in;

import com.blockpage.commentservice.adaptor.infrastructure.entity.CommentEntity;
import com.blockpage.commentservice.application.port.SaveCommentDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

public interface CommentUseCase {

    SaveCommentDto saveComment(CommentQuery commentQuery);

    SaveCommentDto pinComment(CommentQuery commentQuery);

    SaveCommentDto deleteComment(CommentQuery commentQuery);

    void reportComment(Long commentId);

    List<SaveCommentDto> getComment(CommentQuery commentQuery);

    List<SaveCommentDto> getReply(CommentQuery commentQuery);

    Integer getCommentCount(CommentQuery commentQuery);

    @Getter
    @Builder
    class CommentQuery {

        private Long commentId;
        private Long episodeId;
        private Long parentsCommentId;
        private String parentsId;
        private String parentsNickname;
        private String childId;
        private String childNickname;
        private String myProfileImage;
        private String myProfileSkin;

        private String content;
        private int likesCount;
        private int dislikesCount;
        private int replyCount;
        private Boolean report;
        private Boolean erase;
        private Boolean pin;

        public CommentQuery(Long commentId, Long episodeId, Long parentsCommentId, String parentsId, String parentsNickname, String childId,
            String childNickname,
            String myProfileImage, String myProfileSkin, String content, int likesCount, int dislikesCount, int replyCount, Boolean report,
            Boolean erase, Boolean pin) {
            this.commentId = commentId;
            this.episodeId = episodeId;
            this.parentsCommentId = parentsCommentId;
            this.parentsId = parentsId;
            this.parentsNickname = parentsNickname;
            this.childId = childId;
            this.childNickname = childNickname;
            this.myProfileImage = myProfileImage;
            this.myProfileSkin = myProfileSkin;
            this.content = content;
            this.likesCount = likesCount;
            this.dislikesCount = dislikesCount;
            this.replyCount = replyCount;
            this.report = report;
            this.erase = erase;
            this.pin = pin;
        }

        public CommentQuery(Long commentId, Long episodeId, Long parentsCommentId, String parentsId, String parentsNickname,
            String myProfileImage, String myProfileSkin, String content, int likesCount, int dislikesCount, int replyCount, Boolean report,
            Boolean erase, Boolean pin) {
            this.commentId = commentId;
            this.episodeId = episodeId;
            this.parentsCommentId = parentsCommentId;
            this.parentsId = parentsId;
            this.parentsNickname = parentsNickname;
            this.myProfileImage = myProfileImage;
            this.myProfileSkin = myProfileSkin;
            this.content = content;
            this.likesCount = likesCount;
            this.dislikesCount = dislikesCount;
            this.replyCount = replyCount;
            this.report = report;
            this.erase = erase;
            this.pin = pin;
        }

        public static CommentQuery toQueryFromRequest(RequestComment requestComment, String id) {
            if (requestComment.getParentsId() != null) {
                // parentsId 가 비어있다면,
                return CommentQuery.builder()
                    .episodeId(requestComment.getEpisodeId())
                    .parentsCommentId(requestComment.getParentsCommentId())
                    .parentsId(requestComment.getParentsId())
                    .parentsNickname(requestComment.getParentsNickname())
                    .childId(id)
                    .childNickname(requestComment.getNickname())
                    .myProfileImage(requestComment.getProfileImage())
                    .myProfileSkin(requestComment.getProfileSkin())
                    .likesCount(0)
                    .dislikesCount(0)
                    .content(requestComment.getContent())
                    .replyCount(0)
                    .report(false)
                    .erase(false)
                    .pin(false)
                    .build();
            } else {
                return CommentQuery.builder()
                    .episodeId(requestComment.getEpisodeId())
                    .parentsId(id)
                    .parentsNickname(requestComment.getNickname())
                    .myProfileImage(requestComment.getProfileImage())
                    .myProfileSkin(requestComment.getProfileSkin())
                    .likesCount(0)
                    .dislikesCount(0)
                    .content(requestComment.getContent())
                    .replyCount(0)
                    .report(false)
                    .erase(false)
                    .pin(false)
                    .build();
            }
        }

        public static CommentQuery toQueryFromId(Long commentId) {
            return CommentQuery.builder()
                .commentId(commentId)
                .build();
        }

        public static CommentQuery fromParentsId(String commentId) {
            return CommentQuery.builder()
                .parentsId(commentId)
                .build();
        }

        public static CommentQuery toQueryFromEpisodeId(Long episodeId) {
            return CommentQuery.builder()
                .episodeId(episodeId)
                .build();
        }

        public static CommentQuery toQueryFromEntity(CommentEntity commentEntity) {
            return CommentQuery.builder()
                .commentId(commentEntity.getId())
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
    }

}
