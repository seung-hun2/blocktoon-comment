package com.blockpage.commentservice.adaptor.infrastructure.async.message;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCountMessage {

    private Long commentId;
    private Integer likesCount;
    private Integer disLikesCount;
}
