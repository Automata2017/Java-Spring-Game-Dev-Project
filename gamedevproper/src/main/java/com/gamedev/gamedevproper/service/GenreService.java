package com.gamedev.gamedevproper.service;

import com.gamedev.gamedevproper.exceptions.InformationExistException;
import com.gamedev.gamedevproper.exceptions.InformationNotFoundException;
import com.gamedev.gamedevproper.model.Genre;
import com.gamedev.gamedevproper.model.Videogame;
import com.gamedev.gamedevproper.repository.GenreRepository;
import com.gamedev.gamedevproper.repository.VideogameRepository;
import com.gamedev.gamedevproper.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }



    private VideogameRepository videogameRepository;

    @Autowired
    public void setVideogameRepository(VideogameRepository videogameRepository){
        this.videogameRepository = videogameRepository;
    }


    public List<Genre> getAllGenres(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetails.getUser().getId());

        List<Genre> genre = genreRepository.findByUserId(userDetails.getUser().getId());

        if(genre.isEmpty()){
            throw new InformationNotFoundException("no category found for user is " + userDetails.getUser().getId() + " not found");
        } else {
            return genre;
        }

    }

    public Genre createGenre(Genre genreObject){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        Genre genre = genreRepository.findByUserIdAndName(userDetails.getUser().getId(), genreObject.getName());
        if(genre != null){
            throw new InformationExistException("genre with name " + genre.getName() + " already exists");
        } else {
            genreObject.setUser(userDetails.getUser())
            return genreRepository.save(genreObject);
        }
    }

    public Optional<Genre> getGenre(Long genreId){

        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            return genre;
        } else {
            throw new InformationNotFoundException("genre with Id " + genre + " not found");
        }

    }

    public Genre updateGenre(Long genreId, Genre genreObject){
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

    public Optional<Genre> deleteGenre(Long genreId){
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id" + genreId + " not found");
        }
    }

    public Videogame createGenreVideogame(Long genreId, Videogame videogameObject){

        Optional<Genre> genre= genreRepository.findById(genreId);
        videogameObject.setGenre(genre.get());
        return videogameRepository.save(videogameObject);

    }

}
