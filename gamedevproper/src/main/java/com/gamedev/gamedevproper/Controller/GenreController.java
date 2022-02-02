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

    @GetMapping(GenreRepository)
    public List<Genre> getAllGenres(){
        System.out.println("calling getAllGenres");
        return genreRepository.findAll();
    }

    @PostMapping("/genres/")
    public Genre createGenre(@RequestBody Genre genreObject){
        System.out.println("calling createGenre");

        Genre genre = genreRepository.findByName(genreObject.getName());
        if(genre != null){
            throw new InformationExistException("genre with name " + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }

    @GetMapping("/genres/{genreId}/")
    public Optional<Genre> getGenre(@PathVariable(value = "genreId") Long genreId){

        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            return genre;
        } else {
            throw new InformationNotFoundException("genre with Id " + genre + " not found");
        }

    }

    @PutMapping("/genres/{genreId}/")
    public Genre updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody Genre genreObject){
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
             Genre updateGenre = genreRepository.findById(genreId).get();
            updateGenre.setName(genreObject.getName());
            updateGenre.setDescription(genreObject.getDescription());
            return genreRepository.save(updateGenre);
        } else {
            throw new InformationNotFoundException("genre with Id" + genreId + " not found");
        }
    }

    @DeleteMapping("/genres/{genreId}/")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId){
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id" + genreId + " not found");
        }
    }


}
