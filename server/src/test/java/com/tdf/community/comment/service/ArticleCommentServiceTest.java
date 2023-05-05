package com.tdf.community.comment.service;

import com.tdf.community.article.dto.ArticleUpdateDto;
import com.tdf.community.article.entity.Article;
import com.tdf.community.article.repository.ArticleRepository;
import com.tdf.community.comment.dto.ArticleCommentDto;
import com.tdf.community.comment.dto.ArticleCommentUpdateDto;
import com.tdf.community.comment.entity.ArticleComment;
import com.tdf.community.comment.repository.ArticleCommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService articleCommentService;

    @Mock private ArticleRepository articleRepository;
    @Mock private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 Id로 게시글 댓글 리스트를 가져온다.")
    @Test
    void getCommentListByArticleId() {
        Long articleId = 1L;
        Optional<Article> articleComment = Optional.of(Article.of("title", "content", "#pet"));

        given(articleRepository.findById(articleId)).willReturn(articleComment);

        List<ArticleCommentDto> comments = articleCommentService.searchArticleComment(1L);

        assertThat(comments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void createComment() {
        ArticleCommentDto dto = ArticleCommentDto.of("Test Content", LocalDateTime.now(), "writer", LocalDateTime.now(), "udpater");
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        articleCommentService.saveComment(dto);

        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("수정된 댓글 정보를 입력하면, 댓글을 수정한다.")
    @Test
    void updateComment() {
        ArticleCommentUpdateDto dto = ArticleCommentUpdateDto.of("update content");
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        articleCommentService.updateComment(1L, dto);

        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글을 삭제한다.")
    @Test
    void deleteComment() {
        willDoNothing().given(articleCommentRepository).delete(any(ArticleComment.class));

        articleCommentService.deleteComment(1L);

        then(articleCommentRepository).should().delete(any(ArticleComment.class));
    }


}