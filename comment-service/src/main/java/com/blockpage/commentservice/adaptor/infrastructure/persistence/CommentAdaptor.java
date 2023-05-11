package com.blockpage.commentservice.adaptor.infrastructure.persistence;

import com.blockpage.commentservice.adaptor.infrastructure.entity.CommentEntity;
import com.blockpage.commentservice.adaptor.infrastructure.repository.CommentRepository;
import com.blockpage.commentservice.application.port.out.CommentPort;
import com.blockpage.commentservice.domain.CommentDomain;
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
}
