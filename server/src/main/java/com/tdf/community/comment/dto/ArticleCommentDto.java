package com.tdf.community.comment.dto;

import com.tdf.community.article.entity.Article;
import com.tdf.community.comment.entity.ArticleComment;
import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.entity.Member;
import com.tdf.community.member.mapper.MemberMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class ArticleCommentDto {
    private Long id;
    private Long articleId;
    private MemberDto.Response member;
    private String content;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    private static final MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    private ArticleCommentDto(Long id, Long articleId, MemberDto.Response member, String content, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        this.id = id;
        this.articleId = articleId;
        this.member = member;
        this.content = content;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

    public static ArticleCommentDto of(Long articleId, MemberDto.Response member, String content) {
        return new ArticleCommentDto(null, articleId, member, content, null, null, null, null);
    }

    public static ArticleCommentDto of(Long id, Long articleId, MemberDto.Response member, String content, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleCommentDto(id, articleId, member, content, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleCommentDto from(ArticleComment entity) {
        return new ArticleCommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                memberMapper.memberToMemberResponseDto(entity.getMember()),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public ArticleComment toEntity(Article entity, Member member) {
        return ArticleComment.of(
                entity,
                member,
                content
        );
    }
}
