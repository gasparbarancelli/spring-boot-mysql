package com.gasparbarancelli.mysql.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "LINKEDIN", length = 100)
    private String linkedIn;

    @Column(name = "FACEBOOK", length = 100)
    private String faceBook;

    @Column(name = "TWITTER", length = 100)
    private String twitter;

    @Column(name = "SUMMARY")
    private String summary;

    @Deprecated
    public Author() {
    }

    private Author(@NotNull String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public static AuthorBuilder builder(@NotNull String name) {
        return new AuthorBuilder(name);
    }

    public static class AuthorBuilder {

        private final Author author;

        public AuthorBuilder(@NotNull String name) {
            this.author = new Author(name);
        }

        public AuthorBuilder linkedIn(String linkedIn) {
            this.author.linkedIn = linkedIn;
            return this;
        }

        public AuthorBuilder faceBook(String faceBook) {
            this.author.faceBook = faceBook;
            return this;
        }

        public AuthorBuilder twitter(String twitter) {
            this.author.twitter = twitter;
            return this;
        }

        public AuthorBuilder summary(String summary) {
            this.author.summary = summary;
            return this;
        }

        public Author build() {
            return this.author;
        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getFaceBook() {
        return faceBook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
