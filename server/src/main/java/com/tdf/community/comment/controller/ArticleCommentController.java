package com.tdf.community.comment.controller;

import com.tdf.community.comment.dto.ArticleCommentDto;
import com.tdf.community.comment.dto.ArticleCommentRequest;
import com.tdf.community.comment.dto.ArticleCommentResponse;
import com.tdf.community.comment.service.ArticleCommentService;
import com.tdf.community.member.entity.Member;
import com.tdf.community.member.mapper.MemberMapper;
import com.tdf.community.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articleComments")
@RequiredArgsConstructor
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @GetMapping("/{articleId}")
    public ResponseEntity<List<ArticleCommentDto>> getCommentList(@PathVariable Long articleId) {
        List<ArticleCommentDto> comments = articleCommentService.searchArticleComment(articleId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/")
    public ResponseEntity<Void> postNewArticleComment(@RequestBody ArticleCommentRequest dto){
        Member member = memberRepository.getReferenceById(dto.getMemberId());
        articleCommentService.saveComment(dto.toDto(memberMapper.memberToMemberResponseDto(member)));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<Void> updateArticleComment(@RequestBody ArticleCommentDto dto, @PathVariable Long commentId) {
        dto.setId(commentId);
        articleCommentService.updateComment(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteArticleComment(@PathVariable Long commentId) {
        articleCommentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
