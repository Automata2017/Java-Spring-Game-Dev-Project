package com.gamedev.gamedevproper.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {



    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/categories/")
    public String getAllCategories(){
        return "all categories";
    }

    @PostMapping("/categories/")
    public String createCategory(@RequestBody String body){
        return"creating a category " + body;
    }


}
