package com.blockpage.commentservice.application.service;

import com.blockpage.commentservice.application.port.ReportDetailDto;
import com.blockpage.commentservice.application.port.SaveReportDto;
import com.blockpage.commentservice.application.port.in.ReportUseCase;
import com.blockpage.commentservice.application.port.out.ReportPort;
import com.blockpage.commentservice.domain.ReportDomain;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService implements ReportUseCase {

    private final ReportPort reportPort;

    @Override
    public SaveReportDto saveReport(ReportQuery reportQuery) {
        ReportDomain reportDomain = ReportDomain.toDomainFromQuery(reportQuery);
        reportPort.saveReport(reportDomain);

        return SaveReportDto.toDtoFromQuery(reportQuery);
    }

    @Override
    public SaveReportDto solveReport(ReportQuery reportQuery) {
        ReportDomain reportDomain = ReportDomain.toDomainFromQuery(reportQuery);
        reportPort.solveReport(reportDomain);

        return SaveReportDto.toDtoFromQuery(reportQuery);
    }

    @Override
    public List<ReportDetailDto> getReport() {
        List<ReportDomain> reportDomainList = reportPort.getReport();

        return reportDomainList.stream().map(ReportDetailDto::toDtoFromDomain).toList();
    }
}
