package com.blockpage.commentservice.adaptor.infrastructure.repository;

import com.blockpage.commentservice.adaptor.infrastructure.entity.CommentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByEpisodeIdOrderByPinDesc(Long episodeId);

    List<CommentEntity> findAllByParentsCommentId(Long parentsId);

    List<CommentEntity> findAllByEpisodeIdAndEraseIsFalse(Long episodeId);


}
