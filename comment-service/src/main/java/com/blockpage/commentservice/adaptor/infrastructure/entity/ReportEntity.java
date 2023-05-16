package com.blockpage.commentservice.adaptor.infrastructure.entity;

import com.blockpage.commentservice.adaptor.infrastructure.value.ReportType;
import com.blockpage.commentservice.domain.ReportDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long memberId;
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
