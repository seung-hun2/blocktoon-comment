package com.blockpage.commentservice.application.port.out;

import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import com.blockpage.commentservice.domain.CommentDomain;
import java.util.List;

public interface CommentPort {

    void saveComment(CommentDomain commentDomain);

    void pinComment(CommentDomain commentDomain);
    void deleteComment(CommentDomain commentDomain);
    void reportComment(CommentDomain commentDomain);
    List<CommentQuery> getComment(CommentDomain commentDomain);
    List<CommentQuery> getReply(CommentDomain commentDomain);

}
