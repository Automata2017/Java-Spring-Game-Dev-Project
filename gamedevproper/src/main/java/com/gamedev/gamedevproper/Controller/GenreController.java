package com.gamedev.gamedevproper.Controller;

import com.gamedev.gamedevproper.exceptions.InformationExistException;
import com.gamedev.gamedevproper.exceptions.InformationNotFoundException;
import com.gamedev.gamedevproper.model.Genre;
import com.gamedev.gamedevproper.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody String body){
        return "updating the genre with Id of " + genreId + body;
    }

    @DeleteMapping("/genres/{genreId}/")
    public String deleteGenre(@PathVariable(value = "genreId") Long genreId){
        return "deleting the genre with Id of " + genreId;
    }


}
