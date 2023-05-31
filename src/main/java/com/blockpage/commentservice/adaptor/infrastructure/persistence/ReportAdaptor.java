package com.blockpage.commentservice.adaptor.infrastructure.persistence;

import com.blockpage.commentservice.adaptor.infrastructure.entity.ReportEntity;
import com.blockpage.commentservice.adaptor.infrastructure.repository.CommentRepository;
import com.blockpage.commentservice.adaptor.infrastructure.repository.ReportRepository;
import com.blockpage.commentservice.application.port.out.ReportPort;
import com.blockpage.commentservice.domain.ReportDomain;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportAdaptor implements ReportPort {

    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;

    @Override
    public void saveReport(ReportDomain reportDomain) {
        if (commentRepository.findById(reportDomain.getCommentId()).isPresent()) {
            ReportEntity report = ReportEntity.toEntityFromDomain(reportDomain);
            reportRepository.save(report);
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public void solveReport(ReportDomain reportDomain) {
        reportRepository.deleteAllByCommentId(reportDomain.getCommentId());
    }

    @Override
    public List<ReportDomain> getReport() {

        List<ReportEntity> reportEntityList = reportRepository.findAll();

        return reportEntityList.stream().map(ReportDomain::toDomainFromEntity).toList();
    }
}
