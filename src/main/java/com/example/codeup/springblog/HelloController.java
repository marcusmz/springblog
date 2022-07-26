package com.example.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//establishes that this class is a controller
public class HelloController {
//    establishes the URL pattern we are listening for (specifically GET request)

    @GetMapping("/hello")
//    establishes what the body of the response will be
    @ResponseBody
//    defines what the response body will be
    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("/test")

    @ResponseBody
    public String test() {
        return "This is a test page!";
    }

//    @GetMapping("/increment/{num}") OR
    @RequestMapping(path = "/increment/{num}", method = RequestMethod.GET)
    @ResponseBody
    public String increment(@PathVariable int num) {
        return num + " plus one = " + (num + 1) + "!";
    }

}
