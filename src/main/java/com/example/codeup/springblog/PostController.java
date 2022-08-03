package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

//    method	url	description
//    GET	/posts	posts index page

    @GetMapping("/posts")
    public String getPosts(Model vModel) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post(1, "My Post", "This is a post for post 1"),
                new Post(2, "My Post", "This is a post for post 2"),
                new Post(3, "My Post", "This is a post for post 3")
        ));
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

//    GET	/posts/{id}	view an individual post

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model vModel) {
        Post post = new Post(
                1,
                "This is Post #" + id,
                "Here are things about the post..."
        );

        vModel.addAttribute("post", post);
        return "posts/show";
    }

//    GET	/posts/create	view the form for creating a post

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm() {
        return "Form to create post...";
    }

    //    POST	/posts/create	create a new post
    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "Saving post...";
    }


}
