package com.blockpage.commentservice.adaptor.infrastructure.repository;

import com.blockpage.commentservice.adaptor.infrastructure.entity.ReportEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    List<ReportEntity> deleteAllByCommentId(Long commentId);
}
