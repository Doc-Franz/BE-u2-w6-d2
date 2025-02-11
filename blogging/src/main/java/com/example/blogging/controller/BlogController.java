package com.example.blogging.controller;

import com.example.blogging.model.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {

    private static int id = 1;
    private List<Blog> blogList = new ArrayList<>();

    // creazione nuovo blog post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postBlog(@RequestBody Blog blog){
        String titolo = blog.getTitolo();
        int durata = blog.getTempoDiLettura();
        blog.setId(id);
        id++;
        blogList.add(blog);
        return "Il blog " + titolo + " di durata " + blog.getTempoDiLettura() + " è stato inserito nel database" ;
    }

    @GetMapping
    public List<Blog> getAllBlogs(){
        return blogList;
    }

    @GetMapping("/{id}")
    public List<Blog> getSingleBlog(@PathVariable int id){
        return blogList.stream().filter(element -> element.getId() == id).toList();
    }
}
