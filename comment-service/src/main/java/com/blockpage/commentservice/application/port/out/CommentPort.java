package com.blockpage.commentservice.application.port.out;

import com.blockpage.commentservice.domain.CommentDomain;

public interface CommentPort {

    void saveComment(CommentDomain commentDomain);
}
