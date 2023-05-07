package com.tdf.community.article.dto;

import com.tdf.community.article.entity.Article;
import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.mapper.MemberMapper;
import lombok.Getter;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private Long id;
    private MemberDto.Response memberDto;
    private String title;
    private String content;
    private String hashtag;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    private static final MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    private ArticleDto(Long id, MemberDto.Response memberDto, String title, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        this.id = id;
        this.memberDto = memberDto;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

    public static ArticleDto of(Long id, MemberDto.Response memberDto, String title, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, memberDto, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                memberMapper.memberToMemberResponseDto(entity.getMember()),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Article toEntity() {
        return Article.of(
                memberMapper.memberResponseDtoToMember(memberDto),
                title,
                content,
                hashtag
        );
    }
}
