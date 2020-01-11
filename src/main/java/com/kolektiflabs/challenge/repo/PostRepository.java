package com.kolektiflabs.challenge.repo;

import com.kolektiflabs.challenge.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
