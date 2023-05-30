package com.blockpage.commentservice.application.port.out;

import com.blockpage.commentservice.domain.CommentDomain;
import java.util.List;

public interface CommentPort {

    void saveComment(CommentDomain commentDomain);

    void pinComment(CommentDomain commentDomain);
    void deleteComment(CommentDomain commentDomain);
    void reportComment(CommentDomain commentDomain);
    List<CommentDomain> getComment(CommentDomain commentDomain);
    List<CommentDomain> getReply(CommentDomain commentDomain);

    void updateComment(Long commentId, Integer likeCount, Integer dislikeCount);

}
