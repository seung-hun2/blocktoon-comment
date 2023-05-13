package com.blockpage.commentservice.adaptor.web;

import com.blockpage.commentservice.adaptor.web.view.ApiResponseView;
import com.blockpage.commentservice.adaptor.web.view.CommentView;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/comments")
public class CommentController {

    private Long USERID = 1L;
    private String NICKNAME = "승훈";
    private final CommentUseCase commentUseCase;

    @PostMapping()
    public ResponseEntity<ApiResponseView<String>> addComment(@RequestBody RequestComment requestComment) {

        commentUseCase.saveComment(CommentQuery.toQueryFromRequest(requestComment, 1L, "nickname"));

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseView<>("댓글이 생성되었습니다."));
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<ApiResponseView<String>> pinComment(@PathVariable Long id) {

        commentUseCase.pinComment(CommentQuery.toQueryFromId(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>("해당 댓글이 고정되었습니다."));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponseView<String>> deleteComment(@PathVariable Long id) {

        commentUseCase.deleteComment(CommentQuery.toQueryFromId(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>("해당 댓글이 삭제되었습니다."));
    }

    @GetMapping("/{episodeId}")
    public ResponseEntity<ApiResponseView<List<CommentView>>> comments(@PathVariable Long episodeId) {

        List<SaveCommentDto> saveCommentDtos = commentUseCase.getComment(CommentQuery.toQueryFromEpisodeId(episodeId));
        List<CommentView> commentViewList;
        commentViewList = saveCommentDtos.stream().map(CommentView::toViewFromDto).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(commentViewList));

//        List<CommentView> commentViewList = new ArrayList<>();
//        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "명세 똑바로 하세요1", 120, 2, 3, false, false, true));
//        commentViewList.add(new CommentView(1L, 2L, "백고은", null, null, "맨날 침대 다이부 하고 싶다~", 1, 225, 0, false, false, false));
//        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "굿", 12, 2, 0, false, false, false));
//        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "낫배드", 15, 2, 0, false, false, false));
//        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "배드", 1, 2, 0, false, false, false));
//
//        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(commentViewList));
    }

    @GetMapping("/reply/{commentId}")
    public ResponseEntity<ApiResponseView<List<CommentView>>> reply(@PathVariable Long commentId) {

        List<SaveCommentDto> saveCommentDtos = commentUseCase.getReply(CommentQuery.toQueryFromId(commentId));
        List<CommentView> commentViewList;
        commentViewList = saveCommentDtos.stream().map(CommentView::toViewFromDto).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(commentViewList));

    }

}
