package com.blockpage.commentservice.adaptor.web;

import com.blockpage.commentservice.adaptor.web.view.ApiResponseView;
import com.blockpage.commentservice.adaptor.web.view.CommentView;
import com.blockpage.commentservice.adaptor.web.view.MessageView;
import com.blockpage.commentservice.application.port.SaveCommentDto;
import com.blockpage.commentservice.application.port.in.CommentUseCase;
import com.blockpage.commentservice.application.port.in.CommentUseCase.CommentQuery;
import com.blockpage.commentservice.application.port.in.RequestComment;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment-service/v1/comments")
public class CommentController {

    private final CommentUseCase commentUseCase;

    @PostMapping
    public ResponseEntity<ApiResponseView<MessageView>> addComment
        (@RequestBody RequestComment requestComment,
        @RequestHeader String memberId,
        @RequestHeader String nickName) {

        commentUseCase.saveComment(CommentQuery.toQueryFromRequest(requestComment, memberId, nickName));

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseView<>(new MessageView("댓글이 생성되었습니다.")));
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<ApiResponseView<MessageView>> pinComment(@PathVariable Long id) {
        // 작가만 가능 해야함

        commentUseCase.pinComment(CommentQuery.toQueryFromId(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(new MessageView("해당 댓글이 고정되었습니다.")));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponseView<MessageView>> deleteComment(@PathVariable Long id) {
        // 댓글 남긴 사람만 가능 해야함

        commentUseCase.deleteComment(CommentQuery.toQueryFromId(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(new MessageView("해당 댓글이 삭제되었습니다.")));
    }

    @GetMapping("/{episodeId}")
    public ResponseEntity<ApiResponseView<List<CommentView>>> comments(@PathVariable Long episodeId) {

        List<SaveCommentDto> saveCommentDtos = commentUseCase.getComment(CommentQuery.toQueryFromEpisodeId(episodeId));
        List<CommentView> commentViewList;
        commentViewList = saveCommentDtos.stream().map(CommentView::toViewFromDto).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(commentViewList));
    }

    @GetMapping("/reply/{commentId}")
    public ResponseEntity<ApiResponseView<List<CommentView>>> reply(@PathVariable Long commentId) {

        List<SaveCommentDto> saveCommentDtos = commentUseCase.getReply(CommentQuery.toQueryFromId(commentId));
        List<CommentView> commentViewList;
        commentViewList = saveCommentDtos.stream().map(CommentView::toViewFromDto).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(commentViewList));

    }

}
