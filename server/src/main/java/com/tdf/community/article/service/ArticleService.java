package com.tdf.community.article.service;

import com.tdf.community.article.dto.ArticleDto;
import com.tdf.community.article.dto.ArticleWithCommentsDto;
import com.tdf.community.article.entity.Article;
import com.tdf.community.article.repository.ArticleRepository;
import com.tdf.community.article.type.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> getArticles(Pageable pageable) {
        return articleRepository.findAll(pageable).map(ArticleDto::from);
    }

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        if(searchKeyword == null || searchKeyword.isBlank()) {
            return articleRepository.findAll(pageable).map(ArticleDto::from);
        }

        switch (searchType) {
            case TITLE:
                return articleRepository.findByTitleContaining(searchKeyword, pageable).map(ArticleDto::from);
            case CONTENT:
                return articleRepository.findByContentContaining(searchKeyword, pageable).map(ArticleDto::from);
            case ID:
                return articleRepository.findByMember_MemberId(searchKeyword, pageable).map(ArticleDto::from);
            case NICKNAME:
                return articleRepository.findByMember_NicknameContaining(searchKeyword, pageable).map(ArticleDto::from);
            case HASHTAG:
                return articleRepository.findByHashtag(searchKeyword, pageable).map(ArticleDto::from);
            default:
                return null;
        }
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return articleRepository.findById(articleId)
                .map(ArticleWithCommentsDto::from)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다."));
    }

    public void saveArticle(ArticleDto dto) {
        articleRepository.save(dto.toEntity());
    }

    public void updateArticle(ArticleDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.getId());
            if(dto.getTitle() != null) { article.setTitle(dto.getTitle());}
            if(dto.getContent() != null) { article.setContent(dto.getContent()); }
            article.setHashtag(dto.getHashtag());
        } catch (EntityNotFoundException e) {
            log.warn("게시글 업데이트 실패. 게시글을 찾을 수 없습니다 - dto: {}", dto);
        }

    }

    public void deleteArticle(long articleId) {
        articleRepository.deleteById(articleId);
    }
}
