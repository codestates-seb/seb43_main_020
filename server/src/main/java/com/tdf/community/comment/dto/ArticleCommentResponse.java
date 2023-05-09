package com.tdf.community.comment.dto;

import java.time.LocalDateTime;

public class ArticleCommentResponse {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String email;
    private String nickname;

    private ArticleCommentResponse(Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.email = email;
        this.nickname = nickname;
    }

    public static ArticleCommentResponse of (Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleCommentResponse(id, content, createdAt, email, nickname);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        return new ArticleCommentResponse(
                dto.getId(),
                dto.getContent(),
                dto.getCreatedAt(),
                dto.getMember().getEmail(),
                dto.getMember().getNickname()
        );
    }
}
