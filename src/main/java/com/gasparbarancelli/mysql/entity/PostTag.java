package com.gasparbarancelli.mysql.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "POST_TAG")
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TAG")
    private Tag tag;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_POST")
    private Post post;

    @Deprecated
    public PostTag() {
    }

    private PostTag(@NotNull Tag tag, @NotNull Post post) {
        this.tag = Objects.requireNonNull(tag, "tag must not be null");
        this.post = Objects.requireNonNull(post, "post must not be null");
    }

    public static PostTag of(@NotNull Tag tag, @NotNull Post post) {
        return new PostTag(tag, post);
    }

    public Long getId() {
        return id;
    }

    public Tag getTag() {
        return tag;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTag postTag = (PostTag) o;
        return Objects.equals(tag, postTag.tag) && Objects.equals(post, postTag.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, post);
    }

}
