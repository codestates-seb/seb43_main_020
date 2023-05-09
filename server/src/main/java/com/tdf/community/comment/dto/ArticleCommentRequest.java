package com.tdf.community.comment.dto;

import com.tdf.community.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ArticleCommentRequest {
    private Long articleId;
    private Long memberId;
    private String content;

    private ArticleCommentRequest(Long articleId, Long memberId, String content) {
        this.articleId = articleId;
        this.memberId = memberId;
        this.content = content;
    }

    public static ArticleCommentRequest of(Long articleId, Long memberId, String content) {
        return new ArticleCommentRequest(articleId, memberId, content);
    }

    public ArticleCommentDto toDto(MemberDto.Response memberDto) {
        return ArticleCommentDto.of(
                articleId,
                memberDto,
                content
        );
    }
}
