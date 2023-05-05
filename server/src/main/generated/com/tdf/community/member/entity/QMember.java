package com.tdf.community.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -331582405L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final ListPath<com.tdf.community.comment.entity.ArticleComment, com.tdf.community.comment.entity.QArticleComment> articleComments = this.<com.tdf.community.comment.entity.ArticleComment, com.tdf.community.comment.entity.QArticleComment>createList("articleComments", com.tdf.community.comment.entity.ArticleComment.class, com.tdf.community.comment.entity.QArticleComment.class, PathInits.DIRECT2);

    public final ListPath<com.tdf.community.article.entity.Article, com.tdf.community.article.entity.QArticle> articles = this.<com.tdf.community.article.entity.Article, com.tdf.community.article.entity.QArticle>createList("articles", com.tdf.community.article.entity.Article.class, com.tdf.community.article.entity.QArticle.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.ZonedDateTime> created_At = createDateTime("created_At", java.time.ZonedDateTime.class);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final EnumPath<Member.MemberStatus> memberStatus = createEnum("memberStatus", Member.MemberStatus.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath profileImageName = createString("profileImageName");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

