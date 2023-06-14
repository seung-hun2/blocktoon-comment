package com.blockpage.commentservice.adaptor.infrastructure.async.message;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentCountMessage {

    private Long commentId;
    private Integer likesCount;
    private Integer disLikesCount;
}
