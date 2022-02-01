package com.gamedev.gamedevproper.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class GenreController {

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
        
    }



    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/genres/")
    public String getAllGenres(){


        return "all genres";
    }

    @PostMapping("/genres/")
    public String createGenre(@RequestBody String body){
        return "creating a genre " + body;
    }

    @GetMapping("/genres/{genreId}/")
    public String getGenre(@PathVariable Long genreId){
        return "getting the genre with id of " + genreId;
    }

    @PutMapping("/genres/{genreId}/")
    public String updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody String body){
        return "updating the genre with Id of " + genreId + body;
    }

    @DeleteMapping("/genres/{genreId}/")
    public String deleteGenre(@PathVariable(value = "genreId") Long genreId){
        return "deleting the genre with Id of " + genreId;
    }


}
