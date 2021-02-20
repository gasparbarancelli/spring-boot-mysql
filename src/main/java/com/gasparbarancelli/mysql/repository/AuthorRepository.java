package com.gasparbarancelli.mysql.repository;

import com.gasparbarancelli.mysql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
