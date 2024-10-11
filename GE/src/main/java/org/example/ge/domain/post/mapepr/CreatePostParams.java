package org.example.ge.domain.post.mapepr;

public class CreatePostParams {
    private final Long userId;
    private final String imageUrl;

    public CreatePostParams(Long userId, String imageUrl) {
        this.userId = userId;
        this.imageUrl = imageUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
