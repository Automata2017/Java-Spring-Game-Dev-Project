package com.gamedev.gamedevproper.service;

import com.gamedev.gamedevproper.exceptions.InformationExistException;
import com.gamedev.gamedevproper.exceptions.InformationNotFoundException;
import com.gamedev.gamedevproper.model.Genre;
import com.gamedev.gamedevproper.model.Videogame;
import com.gamedev.gamedevproper.repository.GenreRepository;
import com.gamedev.gamedevproper.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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


        return genreRepository.findAll();

    }

    public Genre createGenre(Genre genreObject){

        Genre genre = genreRepository.findByName(genreObject.getName());
        if (genre != null) {
            throw new InformationExistException("genre with name " + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }


    }

    public Optional<Genre> getGenre(Long genreId){

        Optional genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " not found");
        }

    }

    public Genre updateGenre(Long genreId, Genre genreObject){

        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            if (genreObject.getName().equals(genre.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("genre " + genre.get().getName() + " is already exists");
            } else {
                Genre updateGenre = genreRepository.findById(genreId).get();
                updateGenre.setName(genreObject.getName());
                updateGenre.setDescription(genreObject.getDescription());
                return genreRepository.save(updateGenre);
            }
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    public String deleteGenre(Long genreId){
        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre == null) {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");

        } else {
            genreRepository.deleteById(genreId);
            return "Genre with id " + genreId + " has been deleted";
        }
    }

    public Videogame createGenreVideogame(Long genreId, Videogame videogameObject){

        System.out.println("service calling createGenreVideogame ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre == null){
            throw new InformationNotFoundException("genre with id " + genreId + " not belongs to this user or genre does not exist");
        }
        Videogame videogame = videogameRepository.findByNameAndUserId(videogameObject.getTitle(), userDetails.getUser().getId());
        if (videogame != null) {
            throw new InformationExistException("videogame title " + videogame.getTitle());
        }
        videogameObject.setUser(userDetails.getUser());
        videogameObject.setGenre(genre);
        return videogameRepository.save(videogameObject);

    }

    public List<Videogame> getGenreVideogames(Long genreId){
        System.out.println("service calling getGenreVideogames");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if(genre == null) {
            throw new InformationNotFoundException("genre with id " + genreId + " does not belong to this user or genre does not exist");
        }
        return genre.getVideogameList();
    }

    public Videogame getGenreVideogame(Long genreId, Long videogameId){
        System.out.println("service calling createGenreVideogame ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre == null){
            throw new InformationNotFoundException("genre with id " + genreId + " not belongs to this user or genre does not exist");
        }
        Optional<Videogame> videogame = videogameRepository.findByGenreId(
                genreId).stream().filter(p -> p.getId().equals(videogameId)).findFirst();
        if (!videogame.isPresent()){
            throw new InformationNotFoundException("videogame with id" + videogameId + " not belongs to this user or videogame does not exist");
        }
        return videogame.get();
    }

    public Videogame updateGenreVideogame(Long genreId, Long videogameId, Videogame videogameObject){
        System.out.println("service calling updateGenreVideogame ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre == null){
            throw new InformationNotFoundException("genre with id " + genreId + " not belongs to this user or genre does not exist");
        }
        Optional<Videogame> videogame = videogameRepository.findByGenreId(
                genreId).stream().filter(p -> p.getId().equals(videogameId)).findFirst();
        Videogame oldVideogame = videogameRepository.findByNameAndUserIdAndIdIsNot(
                videogameObject.getTitle(), userDetails.getUser().getId(), videogameId);
        if(oldVideogame != null){
            throw new InformationNotFoundException("recipe with name " + oldVideogame.getTitle() + " already exists");
        }
        videogame.get().setTitle(videogameObject.getTitle());
        videogame.get().setDescription(videogameObject.getDescription());
        videogame.get().setMultiplayer(videogameObject.getMultiplayer());
        videogame.get().setDlc(videogameObject.getDlc());
        videogame.get().setCriticScore(videogameObject.getCriticScore());
        videogame.get().setIsReleased(videogameObject.getIsReleased());
        videogame.get().setTitle(videogameObject.getTitle());
        return videogameRepository.save(videogame.get());
    }

    public void deleteGenreVideogame(Long genreId, Long videogameId){
        System.out.println("service calling deleteGenreVideogame ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre == null){
            throw new InformationNotFoundException("genre with id " + genreId + " not belongs to this user or genre does not exist");
        }
        Optional<Videogame> videogame = videogameRepository.findByGenreId(
                genreId).stream().filter(p -> p.getId().equals(videogameId)).findFirst();
        if (videogame.isPresent()){
            throw new InformationNotFoundException("videogame with id " + genreId + " not belongs to this user or videogame does not exist");
        }
        videogameRepository.deleteById(videogame.get().getId());

    }

}
