package com.gamedev.gamedevproper.Controller;

import com.gamedev.gamedevproper.model.Genre;
import com.gamedev.gamedevproper.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Genre> getAllGenres(){

        System.out.println("calling getAllGenres");
        return genreRepository.findAll();
    }

    @PostMapping("/genres/")
    public Genre createGenre(@RequestBody Genre genreObject){
        System.out.println("calling createGenre");

        Genre genre = genreRepository.findByName(genreObject.getName());
        return genreRepository.save(genreObject);
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
