package com.example.restapi.post;

import com.example.restapi.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAll() {
        return repository.findAll();
    }

    public Post getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    public Post create(PostRequest request) {
        return repository.save(new Post(request.title(), request.content()));
    }

    public Post update(Long id, PostRequest request) {
        Post post = getById(id);
        post.setTitle(request.title());
        post.setContent(request.content());
        return repository.save(post);
    }

    public void delete(Long id) {
        Post post = getById(id);
        repository.delete(post);
    }
}
