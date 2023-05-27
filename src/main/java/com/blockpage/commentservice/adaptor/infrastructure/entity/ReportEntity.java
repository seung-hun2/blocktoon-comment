package com.blockpage.commentservice.adaptor.infrastructure.entity;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.domain.ReportDomain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report")
public class ReportEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long commentId;
    @Column
    private String content;
    @Column
    private String memberId;
    @Column
    private String memberNickname;
    @Column
    private ReportType reportType;


    public static ReportEntity toEntityFromDomain(ReportDomain reportDomain) {
        return ReportEntity.builder()
            .memberId(reportDomain.getMemberId())
            .memberNickname(reportDomain.getMemberNickname())
            .commentId(reportDomain.getCommentId())
            .content(reportDomain.getContent())
            .reportType(ReportType.findReportTypeByKey(reportDomain.getReportType().getKey()))
            .build();
    }
}
