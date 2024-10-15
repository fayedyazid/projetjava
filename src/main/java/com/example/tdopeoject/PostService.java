package com.example.tdopeoject;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post createPost(Post post);
    Post getPostById(long id) throws ResourceNotFoundException;
}
