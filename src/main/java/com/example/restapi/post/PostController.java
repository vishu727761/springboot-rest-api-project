package com.example.restapi.post;

import com.example.restapi.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Post>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Posts fetched successfully", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Post fetched successfully", service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Post>> create(@Valid @RequestBody PostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Post created successfully", service.create(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>> update(@PathVariable Long id,
                                                     @Valid @RequestBody PostRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Post updated successfully", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Post deleted successfully", null));
    }
}
