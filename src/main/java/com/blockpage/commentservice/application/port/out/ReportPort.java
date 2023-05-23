package com.blockpage.commentservice.application.port.out;

import com.blockpage.commentservice.domain.ReportDomain;
import java.util.List;

public interface ReportPort {
    void saveReport(ReportDomain reportDomain);
    void solveReport(ReportDomain reportDomain);
    List<ReportDomain> getReport(Long commentId);

}
