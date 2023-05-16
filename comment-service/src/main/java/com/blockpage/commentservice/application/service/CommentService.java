package com.blockpage.commentservice.application.service;

import com.blockpage.commentservice.application.port.SaveCommentDto;
import com.blockpage.commentservice.application.port.in.CommentUseCase;
import com.blockpage.commentservice.application.port.out.CommentPort;
import com.blockpage.commentservice.domain.CommentDomain;
import java.util.List;
import java.util.stream.Collectors;
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

    @Override
    public SaveCommentDto pinComment(CommentQuery commentQuery) {

        CommentDomain commentDomain = CommentDomain.toDomainFrom(commentQuery);
        commentPort.pinComment(commentDomain);

        return SaveCommentDto.toDtoFromQuery(commentQuery);
    }

    @Override
    public SaveCommentDto deleteComment(CommentQuery commentQuery) {

        CommentDomain commentDomain = CommentDomain.toDomainFrom(commentQuery);
        commentPort.deleteComment(commentDomain);

        return SaveCommentDto.toDtoFromQuery(commentQuery);
    }

    @Override
    public void reportComment(Long commentId) {
        CommentDomain commentDomain = CommentDomain.toDomainFromId(commentId);
        commentPort.reportComment(commentDomain);
    }

    @Override
    public List<SaveCommentDto> getComment(CommentQuery commentQuery) {

        CommentDomain commentDomain = CommentDomain.toDomainFrom(commentQuery);
        List<CommentQuery> commentQueryList = commentPort.getComment(commentDomain);

        List<CommentQuery> result = commentQueryList.stream()
            .filter(w -> !(w.getErase() && w.getReplyCount() == 0)).toList();

        return result.stream().map(SaveCommentDto::toDtoFromQuery).collect(Collectors.toList());

    }

    @Override
    public List<SaveCommentDto> getReply(CommentQuery commentQuery) {

        CommentDomain commentDomain = CommentDomain.toDomainFrom(commentQuery);
        List<CommentQuery> commentQueryList = commentPort.getReply(commentDomain);

        List<CommentQuery> result = commentQueryList.stream()
            .filter(w -> !(w.getErase() && w.getReplyCount() == 0)).toList();

        return result.stream().map(SaveCommentDto::toDtoFromQuery).collect(Collectors.toList());
    }
}
