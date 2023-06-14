package com.blockpage.commentservice.application.port.in;

import com.blockpage.commentservice.adaptor.infrastructure.async.message.CommentCountMessage;
import lombok.Builder;
import lombok.Getter;

public interface CommentCountUseCase {

    void updateComment(CommentCountQuery commentCountQuery);


    @Getter
    @Builder
    class CommentCountQuery {

        private Long commentId;
        private Integer likesCount;
        private Integer disLikesCount;

        public static CommentCountQuery toQuery(CommentCountMessage commentCountMessage) {
            return CommentCountQuery.builder()
                .commentId(commentCountMessage.getCommentId())
                .likesCount(commentCountMessage.getLikesCount())
                .disLikesCount(commentCountMessage.getDisLikesCount())
                .build();
        }
    }

}
