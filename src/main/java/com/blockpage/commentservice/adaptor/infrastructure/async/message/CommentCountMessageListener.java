package com.blockpage.commentservice.adaptor.infrastructure.async.message;

import com.blockpage.commentservice.application.port.in.CommentCountUseCase;
import com.blockpage.commentservice.application.port.in.CommentCountUseCase.CommentCountQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentCountMessageListener {

    private final CommentCountUseCase commentCountUseCase;

    @KafkaListener(
        topics = "${spring.kafka.commentTopic}",
        groupId = "${spring.kafka.commentGroup}",
        containerFactory = "KafkaListenerContainerFactory"
    )
    public void listenWithHeaders(@Payload CommentCountMessage commentCountMessage, @Headers MessageHeaders messageHeaders) {
        commentCountUseCase.updateComment(CommentCountQuery.toQuery(commentCountMessage));
    }
}
