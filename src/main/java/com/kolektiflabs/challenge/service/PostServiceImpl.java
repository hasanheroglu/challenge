package com.kolektiflabs.challenge.service;

import com.kolektiflabs.challenge.model.PostDto;
import com.kolektiflabs.challenge.model.PostEntity;
import com.kolektiflabs.challenge.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostEntity create(PostDto postDto) {
        PostEntity post = new PostEntity(postDto);
        postRepository.save(post);
        return post;
    }

    @Override
    public PostEntity read(Long id) {
        Optional<PostEntity> optionalPost = postRepository.findById(id);

        if(!optionalPost.isPresent()) { return null; }

        return optionalPost.get();
    }

    @Override
    public PostEntity update(Long id, PostDto postDto) {
        Optional<PostEntity> optionalPost = postRepository.findById(id);

        if(!optionalPost.isPresent()) { return null; }

        PostEntity post = optionalPost.get();
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());

        postRepository.save(post);

        return post;
    }

    @Override
    public PostEntity delete(Long id) {
        Optional<PostEntity> optionalPost = postRepository.findById(id);

        if(!optionalPost.isPresent()) { return null; }
        PostEntity post = optionalPost.get();

        postRepository.delete(post);

        return post;
    }
}
