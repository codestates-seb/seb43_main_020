package com.tdf.community.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private String title;
    private String content;
    private String hashtag;
    private LocalDateTime createdAt;
    private String createdBy;

    private ArticleDto(String title, String content, String hashtag, LocalDateTime createdAt, String createdBy) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static ArticleDto of(String title, String content, String hashtag, LocalDateTime createdAt, String createdBy) {
        return new ArticleDto(title, content, hashtag, createdAt, createdBy);
    }
}
