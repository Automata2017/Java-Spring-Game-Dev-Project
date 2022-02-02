package com.gamedev.gamedevproper.service;

import com.gamedev.gamedevproper.model.Genre;
import com.gamedev.gamedevproper.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres/")
    public List<Genre> getAllGenres(){
        System.out.println("calling getAllGenres");
        return genreRepository.findAll();
    }

}
