package com.gamedev.gamedevproper.Controller;

import com.gamedev.gamedevproper.exceptions.InformationExistException;
import com.gamedev.gamedevproper.exceptions.InformationNotFoundException;
import com.gamedev.gamedevproper.model.Genre;
import com.gamedev.gamedevproper.repository.GenreRepository;
import com.gamedev.gamedevproper.service.GenreService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class GenreController {

//    private GenreRepository genreRepository;
//
//    @Autowired
//    public void setGenreRepository(GenreRepository genreRepository){
//        this.genreRepository = genreRepository;
//
//    }

    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService){
        this.genreService = genreService;

    }



    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/genres/")
    public List<Genre> getAllGenres(){
        System.out.println("calling getAllGenres");
        return genreService.getAllGenres();
    }

    @PostMapping("/genres/")
    public Genre createGenre(@RequestBody Genre genreObject){
        System.out.println("calling createGenre");
        return genreService.createGenre(genreObject)
    }

    @GetMapping("/genres/{genreId}/")
    public Optional<Genre> getGenre(@PathVariable(value = "genreId") Long genreId){

        return genreService.getGenre(genreId);

    }

    @PutMapping("/genres/{genreId}/")
    public Genre updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody Genre genreObject){
        return genreService.updateGenre(genreId, genreObject);
    }

    @DeleteMapping("/genres/{genreId}/")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId){
        return genreService.deleteGenre(genreId);
    }


}
