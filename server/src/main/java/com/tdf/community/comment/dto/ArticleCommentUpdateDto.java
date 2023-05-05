package com.tdf.community.comment.dto;

public class ArticleCommentUpdateDto {
    private String content;

    private ArticleCommentUpdateDto(String content) {
        this.content = content;
    }

    public static ArticleCommentUpdateDto of (String content) {
        return new ArticleCommentUpdateDto(content);
    }
}
