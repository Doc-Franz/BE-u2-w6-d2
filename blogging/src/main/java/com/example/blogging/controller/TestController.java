package com.example.blogging.controller;

import com.example.blogging.model.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class TestController {

    private List<Blog> blogList = new ArrayList<>();

    // creazione nuovo blog post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postBlog(@RequestBody Blog blog){
        blogList.add(blog);
        return "Blog aggiunto alla lista!";
    }

    @GetMapping
    public List<Blog> getAllBlogs(){
        return blogList;
    }
}
