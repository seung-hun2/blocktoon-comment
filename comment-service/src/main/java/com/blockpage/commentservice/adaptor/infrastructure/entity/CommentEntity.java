package com.blockpage.commentservice.adaptor.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
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
}