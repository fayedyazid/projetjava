package com.example.tdopeoject;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private ModelMapper modelMapper;

    private PostService postService;

    public PostController(ModelMapper modelMapper, PostService postService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts() {

        return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        Post post = postService.getPostById(id);
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok(postResponse);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        // convert DTO to entity
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.createPost(postRequest);
        // convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }


}
