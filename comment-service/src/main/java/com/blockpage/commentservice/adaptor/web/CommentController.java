package com.blockpage.commentservice.adaptor.web;

import com.blockpage.commentservice.adaptor.web.view.ApiResponseView;
import com.blockpage.commentservice.adaptor.web.view.CommentView;
import com.blockpage.commentservice.application.port.in.RequestComment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/comments")
public class CommentController {
    @PostMapping()
    public ResponseEntity addComment(@RequestBody RequestComment requestComment) {
        // requestComment를 DB에 저장시키는 서비스 로직 구현해야함
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseView<>("댓글이 생성되었습니다."));
    }

    @PatchMapping()
    public ResponseEntity pinComment(@RequestBody RequestComment requestComment){
        // 핀 고정하는 서비스 로직 구현 해야함 ( pin 속성값만 바꿔주면 됨 false -> true )
        return ResponseEntity.status(HttpStatus.OK).body("해당 댓글이 고정되었습니다.");
    }

    @DeleteMapping()
    public ResponseEntity deleteComment(@RequestBody RequestComment requestComment){
        // 삭제하는 서비스 로직 구현 해야함 ( comment에 "삭제된 댓글입니다." + erase 속성값 바꿔주면 됨 false -> true )
        return ResponseEntity.status(HttpStatus.OK).body("해당 댓글이 삭제되었습니다.");
    }

    @GetMapping()
    public ResponseEntity<ApiResponseView> comments(@RequestParam Long episodeId) {
        List<CommentView> commentViewList = new ArrayList<>();
        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "명세 똑바로 하세요1", 120, 2, 3, false, false, true));
        commentViewList.add(new CommentView(1L, 2L, "백고은", null, null, "맨날 침대 다이부 하고 싶다~", 1, 225, 0, false, false, false));
        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "굿", 12, 2, 0, false, false, false));
        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "낫배드", 15, 2, 0, false, false, false));
        commentViewList.add(new CommentView(1L, 1L, "김태근", null, null, "배드", 1, 2, 0, false, false, false));

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseView<>(commentViewList));
    }
}
