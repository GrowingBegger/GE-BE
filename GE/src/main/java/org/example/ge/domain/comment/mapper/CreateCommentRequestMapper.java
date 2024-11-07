package org.example.ge.domain.comment.mapper;

import org.example.ge.domain.comment.dto.request.CreateCommentRequest;
import org.example.ge.domain.comment.entity.Comment;
import org.example.ge.instrastructure.common.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CreateCommentRequestMapper implements Mapper<CreateCommentRequest, Comment, CreateCommentParams> {
    @Override
    public Comment toEntity(CreateCommentRequest dto, CreateCommentParams params) {
        return Comment.builder()
                .userId(params.userId())
                .postId(params.postId())
                .content(dto.content())
                .build();
    }

    @Override
    public CreateCommentRequest toDto(Comment entity, CreateCommentParams params) {
        return null;
    }
}
