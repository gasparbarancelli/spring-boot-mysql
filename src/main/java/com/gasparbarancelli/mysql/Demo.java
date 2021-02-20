package com.gasparbarancelli.mysql;

import com.gasparbarancelli.mysql.entity.Author;
import com.gasparbarancelli.mysql.entity.Post;
import com.gasparbarancelli.mysql.entity.Tag;
import com.gasparbarancelli.mysql.repository.AuthorRepository;
import com.gasparbarancelli.mysql.repository.PostRepository;
import com.gasparbarancelli.mysql.repository.TagRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class Demo {

    private final TagRepository tagRepository;
    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    public Demo(TagRepository tagRepository, AuthorRepository authorRepository, PostRepository postRepository) {
        this.tagRepository = tagRepository;
        this.authorRepository = authorRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void demo() {
        var post = Post.of(
                "Banco de dados MySQL com Spring Boot",
                "O MySQL é um sistema de gerenciamento de banco de dados...",
                "O MySQL é um sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface. É atualmente um dos sistemas de gerenciamento de bancos de dados mais populares..."
        );

        var author = Author.builder("Gaspar Barancelli Junior")
                .linkedIn("https://www.linkedin.com/in/gaspar-barancelli-junior-77681881/")
                .twitter("https://twitter.com/gasparbjr")
                .faceBook("https://www.facebook.com/gaspar.barancelli/")
                .summary("Senior software engineer at Dextra, passionate about technology, because I understand that through it we can bring people together and make our world a better")
                .build();
        authorRepository.save(author);
        post.addAuthor(author);

        var tag = Tag.of("Java");
        tagRepository.save(tag);
        post.addTag(tag);

        var tags = List.of(
                Tag.of("Mysql"),
                Tag.of("Banco de Dados"),
                Tag.of("JPA")
        );
        tagRepository.saveAll(tags);
        post.addTags(tags);

        postRepository.save(post);

        postRepository.findAll().forEach(it -> {
            System.out.printf("Post - ID[%d], TITLE[%s]%n", it.getId(), it.getTitle());
            it.getAuthors().forEach(postAuthor -> {
                System.out.printf("PostAuthor - ID[%d], AUTHOR_NAME[%s]%n", postAuthor.getId(), postAuthor.getAuthor().getName());
            });
            it.getTags().forEach(postTag -> {
                System.out.printf("PostTag - ID[%d], TAG_DESCRIPTION[%s]%n", postTag.getId(), postTag.getTag().getDescription());
            });
        });

        authorRepository.findAll().forEach(it -> {
            System.out.printf("Author - ID[%d], NAME[%s]%n", it.getId(), it.getName());
        });

        tagRepository.findAll().forEach(it -> {
            System.out.printf("Tag - ID[%d], DESCRIPTION[%s]%n", it.getId(), it.getDescription());
        });
    }

}
