package org.example.ge.domain.post.dto.response.postDetail;

import java.util.List;

public record GetPostDetailResponse(
    PostDto post,
    List<Integer> likes,
    List<CommentDto> comment
) {
}
