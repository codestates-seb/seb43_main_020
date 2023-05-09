package com.tdf.community.comment.service;

import com.tdf.community.article.entity.Article;
import com.tdf.community.article.repository.ArticleRepository;
import com.tdf.community.comment.dto.ArticleCommentDto;
import com.tdf.community.comment.entity.ArticleComment;
import com.tdf.community.comment.repository.ArticleCommentRepository;
import com.tdf.community.member.entity.Member;
import com.tdf.community.member.mapper.MemberMapper;
import com.tdf.community.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long articleId) {
        return articleCommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(ArticleCommentDto::from)
                .collect(Collectors.toList());
    }

    public void saveComment(ArticleCommentDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.getArticleId());
            Member member = memberRepository.getReferenceById(dto.getMember().getMemberId());
            articleCommentRepository.save(dto.toEntity(article, member));
        } catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글작성에 필요한 정보를 찾을 수 없습니다.");
        }
    }

    public void updateComment(ArticleCommentDto dto) {
        try {
            ArticleComment articleComment = articleCommentRepository.getReferenceById(dto.getId());
            if (dto.getContent() != null) {
                articleComment.setContent(dto.getContent());
            }
        } catch (EntityNotFoundException e) {
            log.warn("댓글 업데이트 실패. 댓글을 찾을 수 없습니다.");
        }
    }

    public void deleteComment(long commentId) {
        articleCommentRepository.deleteById(commentId);
    }
}
