package com.kolektiflabs.challenge.controller;

import com.kolektiflabs.challenge.model.PostDto;
import com.kolektiflabs.challenge.model.PostEntity;
import com.kolektiflabs.challenge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<Iterable<PostEntity>> readAll(){
        return new ResponseEntity<Iterable<PostEntity>>(postService.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostEntity> create(@RequestBody PostDto postDto){
        return new ResponseEntity<PostEntity>(postService.create(postDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> read(@PathVariable("id") Long id){
        return new ResponseEntity<PostEntity>(postService.read(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> update(@PathVariable("id") Long id, @RequestBody PostDto postDto){
        return new ResponseEntity<PostEntity>(postService.update(id, postDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostEntity> delete(@PathVariable("id") Long id){
        return new ResponseEntity<PostEntity>(postService.delete(id), HttpStatus.OK);
    }
}
