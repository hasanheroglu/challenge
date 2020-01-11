package com.kolektiflabs.challenge.service;


import com.kolektiflabs.challenge.model.PostDto;
import com.kolektiflabs.challenge.model.PostEntity;

public interface PostService {
    PostEntity create(PostDto postDto);
    PostEntity read(Long id);
    Iterable<PostEntity> readAll();
    PostEntity update(Long id, PostDto postDto);
    PostEntity delete(Long id);
}
