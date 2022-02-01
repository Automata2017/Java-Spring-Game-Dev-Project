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
        return "creating a category " + body;
    }

    @GetMapping("/categories/{categoryId}/")
    public String getCategory(@PathVariable Long categoryId){
        return "getting the category with id of " + categoryId;
    }

    @PutMapping("/categories/{categoryId}/")
    public String updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody String body){
        return "updating the category with Id of" + categoryId + body;
    }


}
