package com.blockpage.commentservice.adaptor.infrastructure.entity;

import com.blockpage.commentservice.domain.CommentDomain;
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
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long episodeId;
    @Column
    private Long parentsId;
    @Column
    private String parentsNickname;
    @Column
    private Long childId;
    @Column
    private String childNickname;
    @Column
    private String content;
    @Column
    private int likesCount;
    @Column
    private int dislikesCount;
    @Column
    private Boolean report;
    @Column
    private Boolean erase;
    @Column
    private int replyCount;
    @Column
    private Boolean pin;

    public void update(Boolean pin) {
        this.pin = pin;
    }

    public void delete(Boolean erase, String content) {
        this.erase = erase;
        this.content = content;
    }

    public void report(Boolean report, String content) {
        this.report = report;
        this.content = content;
    }

    public static CommentEntity toEntityFromDomain(CommentDomain commentDomain) {
        return CommentEntity.builder()
            .episodeId(commentDomain.getEpisodeId())
            .parentsId(commentDomain.getParentsId())
            .parentsNickname(commentDomain.getParentsNickname())
            .childId(commentDomain.getChildId())
            .childNickname(commentDomain.getChildNickname())
            .content(commentDomain.getContent())
            .replyCount(commentDomain.getReplyCount())
            .likesCount(commentDomain.getLikesCount())
            .dislikesCount(commentDomain.getDislikesCount())
            .report(commentDomain.getReport())
            .erase(commentDomain.getErase())
            .pin(commentDomain.getPin())
            .build();
    }

}