package com.blockpage.commentservice.adaptor.infrastructure.persistence;

import com.blockpage.commentservice.adaptor.infrastructure.entity.CommentEntity;
import com.blockpage.commentservice.adaptor.infrastructure.repository.CommentRepository;
import com.blockpage.commentservice.application.port.out.CommentPort;
import com.blockpage.commentservice.domain.CommentDomain;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentAdaptor implements CommentPort {

    private final CommentRepository commentRepository;

    @Override
    public void saveComment(CommentDomain commentDomain) {

        CommentEntity commentEntity = CommentEntity.toEntityFromDomain(commentDomain);
        commentRepository.save(commentEntity);


    }

    @Override
    @Transactional
    public void pinComment(CommentDomain commentDomain) {

        Optional<CommentEntity> commentEntity = commentRepository.findById(commentDomain.getCommentId());
        commentEntity.get().update(true);

    }

    @Override
    @Transactional
    public void deleteComment(CommentDomain commentDomain) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentDomain.getCommentId());
        commentEntity.get().delete(true, "삭제된 댓글 입니다.");
    }

    @Override
    @Transactional
    public void reportComment(CommentDomain commentDomain) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentDomain.getCommentId());
        commentEntity.get().report(true, "신고되어 삭제된 댓글 입니다.");
    }

    @Override
    public List<CommentDomain> getComment(CommentDomain commentDomain) {
        List<CommentEntity> commentEntityList = commentRepository.findByEpisodeId(commentDomain.getEpisodeId());
        return commentEntityList.stream().map(CommentDomain::toDomainFromEntity).toList();
    }

    @Override
    public List<CommentDomain> getReply(CommentDomain commentDomain) {
        List<CommentEntity> commentEntityList = commentRepository.findByParentsId(commentDomain.getCommentId());

        return commentEntityList.stream().map(CommentDomain::toDomainFromEntity).toList();
    }
}
