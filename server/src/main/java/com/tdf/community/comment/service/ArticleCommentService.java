package com.tdf.community.comment.service;

import com.tdf.community.article.repository.ArticleRepository;
import com.tdf.community.comment.dto.ArticleCommentDto;
import com.tdf.community.comment.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long l) {
        return List.of();
    }

    public void saveComment(ArticleCommentDto dto) {
    }

    public void updateComment(ArticleCommentDto dto) {
    }

    public void deleteComment(long commentId) {
    }
}
