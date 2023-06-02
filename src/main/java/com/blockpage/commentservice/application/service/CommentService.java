package com.blockpage.commentservice.application.service;

import com.blockpage.commentservice.application.port.SaveCommentDto;
import com.blockpage.commentservice.application.port.in.CommentCountUseCase;
import com.blockpage.commentservice.application.port.in.CommentUseCase;
import com.blockpage.commentservice.application.port.out.CommentPort;
import com.blockpage.commentservice.domain.CommentDomain;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentUseCase, CommentCountUseCase {

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
        List<CommentDomain> commentDomainList = commentPort.getComment(commentDomain);
        List<CommentDomain> result = CommentDomain.getComment(commentDomainList);

        return result.stream().map(SaveCommentDto::toDtoFromDomain).collect(Collectors.toList());

    }

    @Override
    public List<SaveCommentDto> getReply(CommentQuery commentQuery) {

        CommentDomain commentDomain = CommentDomain.toDomainFrom(commentQuery);
        List<CommentDomain> commentDomainList = commentPort.getReply(commentDomain);
        List<CommentDomain> result = CommentDomain.getComment(commentDomainList);

        return result.stream().map(SaveCommentDto::toDtoFromDomain).collect(Collectors.toList());
    }

    @Override
    public Integer getCommentCount(CommentQuery commentQuery) {
        CommentDomain commentDomain = CommentDomain.toDomainFromEpisodeId(commentQuery.getEpisodeId());

        return commentPort.getCommentCount(commentDomain.getEpisodeId());
    }

    @Override
    public void updateComment(CommentCountQuery commentCountQuery) {
        commentPort.updateComment(commentCountQuery.getCommentId(), commentCountQuery.getLikeCount(), commentCountQuery.getDislikeCount());
    }
}
