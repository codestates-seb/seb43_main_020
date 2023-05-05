package com.tdf.community.article.service;

import com.mysema.commons.lang.Assert;
import com.tdf.community.article.dto.ArticleDto;
import com.tdf.community.article.dto.ArticleUpdateDto;
import com.tdf.community.article.entity.Article;
import com.tdf.community.article.repository.ArticleRepository;
import com.tdf.community.article.type.SearchType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService articleService;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환 with 페이지네이션")
    @Test
    void searchArticle() {
            Page<ArticleDto> articles = articleService.searchArticles(SearchType.TITLE, "search keyword");

            assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void searchArticleWithPageInfo() {
        ArticleDto article = articleService.searchArticle(1L);

        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void createArticle() {
        ArticleDto dto = ArticleDto.of("Test", "Test content", "#pet", LocalDateTime.now(), "test user");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        articleService.saveArticle(dto);

        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("수정된 게시글 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void updateArticle() {
        ArticleUpdateDto dto = ArticleUpdateDto.of("Test", "Test content", "#pet");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        articleService.updateArticle(1L, dto);

        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글을 삭제한다.")
    @Test
    void updateArticle() {
        willDoNothing().given(articleRepository).delete(any(Article.class));

        articleService.deleteArticle(1L);

        then(articleRepository).should().delete(any(Article.class));
    }
}