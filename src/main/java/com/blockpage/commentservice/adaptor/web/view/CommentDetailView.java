package com.blockpage.commentservice.adaptor.web.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class CommentDetailView {

    private Integer count;
    private List<CommentView> commentViewList;

    public CommentDetailView(Integer count, List<CommentView> commentViewList) {
        this.count = count;
        this.commentViewList = commentViewList;
    }

    public static CommentDetailView toView(Integer count, List<CommentView> commentViewList){
        return new CommentDetailView(count,commentViewList);
    }
}
