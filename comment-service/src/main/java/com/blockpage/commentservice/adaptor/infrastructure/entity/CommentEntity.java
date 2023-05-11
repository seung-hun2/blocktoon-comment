package com.blockpage.commentservice.adaptor.infrastructure.entity;

import com.blockpage.commentservice.domain.CommentDomain;
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
@Table(schema = "comment")
public class CommentEntity {

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

    public static CommentEntity toEntityFromDomain(CommentDomain commentDomain){
        return CommentEntity.builder()
            .episodeId(commentDomain.getEpisodeId())
            .childId(commentDomain.getChildId())
            .childNickname(commentDomain.getChildNickname())
            .parentsId(commentDomain.getParentsId())
            .parentsNickname(commentDomain.getParentsNickname())
            .content(commentDomain.getComment())
            .likesCount(commentDomain.getLikesCount())
            .dislikesCount(commentDomain.getDislikesCount())
            .report(commentDomain.getReport())
            .erase(commentDomain.getErase())
            .pin(commentDomain.getPin())
            .build();
    }
}