package com.example.firstproject.entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private String nickname;
    private String body;

    public Comment() {}

    public Comment(Long id, Article article, String nickname, String body) {
        this.id = id;
        this.article = article;
        this.nickname = nickname;
        this.body = body;
    }

    public Long getId() { return id; }
    public Article getArticle() { return article; }
    public String getNickname() { return nickname; }
    public String getBody() { return body; }
}
