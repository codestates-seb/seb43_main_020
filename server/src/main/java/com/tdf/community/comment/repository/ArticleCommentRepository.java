package com.tdf.community.comment.repository;

import com.tdf.community.article.repository.ArticleRepository;
import com.tdf.community.comment.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {}
