package com.gasparbarancelli.mysql.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "POST_AUTHOR")
public class PostAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_AUTHOR")
    private Author author;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_POST")
    private Post post;

    @Deprecated
    public PostAuthor() {
    }

    private PostAuthor(@NotNull Author author, @NotNull Post post) {
        this.author = Objects.requireNonNull(author, "author must not be null");
        this.post = Objects.requireNonNull(post, "post must not be null");
    }

    public static PostAuthor of(@NotNull Author author, @NotNull Post post) {
        return new PostAuthor(author, post);
    }

    public Long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostAuthor that = (PostAuthor) o;
        return Objects.equals(author, that.author) && Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, post);
    }

}
