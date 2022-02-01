package com.gamedev.gamedevproper.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {



    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/catagories/")
    public String getAllCategories(){
        return "all categories";
    }


}
