package com.tdf.community.article.controller;

import com.tdf.community.article.dto.ArticleDto;
import com.tdf.community.article.dto.ArticleWithCommentsDto;
import com.tdf.community.article.service.ArticleService;
import com.tdf.community.article.type.SearchType;
import com.tdf.community.member.dto.MemberDto;
import com.tdf.community.member.mapper.MemberMapper;
import com.tdf.community.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @GetMapping("/")
    public ResponseEntity<Page<ArticleDto>> searchArticles(
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<ArticleDto> articles = articleService.getArticles(pageable);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ArticleDto>> searchArticles(
            @RequestParam SearchType searchType,
            @RequestParam String searchKeyword,
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<ArticleDto> articles = articleService.searchArticles(searchType, searchKeyword, pageable);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleWithCommentsDto> getArticle(@PathVariable Long articleId) {
        ArticleWithCommentsDto article = articleService.getArticle(articleId);
        return ResponseEntity.ok(article);
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto dto, @PathVariable Long memberId) {
        MemberDto.Response member = memberMapper.memberToMemberResponseDto(memberService.findMember(memberId));
        dto.setMemberDto(member);
        articleService.saveArticle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long articleId, @RequestBody ArticleDto dto) {
        dto.setId(articleId);
        articleService.updateArticle(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.noContent().build();
    }
}
