package com.gasparbarancelli.mysql.repository;

import com.gasparbarancelli.mysql.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
