package com.tdf.community.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = -351685459L;

    public static final QArticle article = new QArticle("article");

    public final com.tdf.community.audit.QAuditingFields _super = new com.tdf.community.audit.QAuditingFields(this);

    public final SetPath<com.tdf.community.comment.entity.ArticleComment, com.tdf.community.comment.entity.QArticleComment> articleComments = this.<com.tdf.community.comment.entity.ArticleComment, com.tdf.community.comment.entity.QArticleComment>createSet("articleComments", com.tdf.community.comment.entity.ArticleComment.class, com.tdf.community.comment.entity.QArticleComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath hashtag = createString("hashtag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath title = createString("title");

    public QArticle(String variable) {
        super(Article.class, forVariable(variable));
    }

    public QArticle(Path<? extends Article> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticle(PathMetadata metadata) {
        super(Article.class, metadata);
    }

}

