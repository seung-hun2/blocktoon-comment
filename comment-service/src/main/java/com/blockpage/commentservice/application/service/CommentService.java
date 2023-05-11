package com.blockpage.commentservice.application.service;

import com.blockpage.commentservice.application.port.SaveCommentDto;
import com.blockpage.commentservice.application.port.in.CommentUseCase;
import com.blockpage.commentservice.application.port.out.CommentPort;
import com.blockpage.commentservice.domain.CommentDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentUseCase {

    private final CommentPort commentPort;

    @Override
    public SaveCommentDto saveComment(CommentQuery commentQuery) {

        CommentDomain commentDomain = CommentDomain.toDomainFrom(commentQuery);
        commentPort.saveComment(commentDomain);

        return SaveCommentDto.toDtoFromQuery(commentQuery);

    }
}
