package com.tdf.community.comment.entity;


import com.tdf.community.article.entity.Article;
import com.tdf.community.audit.AuditingFields;
import com.tdf.community.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class ArticleComment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private Article article; // 게시글 (ID)
    @Setter @ManyToOne(optional = false) private Member member;

    @Setter @Column(nullable = false, length = 500) private String content; // 본문

    protected ArticleComment() {}

    private ArticleComment(Article article, Member member, String content) {
        this.article = article;
        this.member = member;
        this.content = content;
    }

    public static ArticleComment of(Article article, Member member, String content) {
        return new ArticleComment(article, member, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment)) return false;
        ArticleComment that = (ArticleComment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
