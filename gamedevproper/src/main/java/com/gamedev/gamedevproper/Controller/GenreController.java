package com.gamedev.gamedevproper.Controller;

        import com.gamedev.gamedevproper.exceptions.InformationExistException;
        import com.gamedev.gamedevproper.exceptions.InformationNotFoundException;
        import com.gamedev.gamedevproper.model.Genre;
        import com.gamedev.gamedevproper.model.Videogame;
        import com.gamedev.gamedevproper.repository.GenreRepository;
        import com.gamedev.gamedevproper.service.GenreService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.HashMap;
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
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    //@GetMapping = get method in rest terms
    @GetMapping("/hello-world/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/genres/")
    public List<Genre> getAllGenres(){
        System.out.println("calling getAllGenres");
        return genreService.getAllGenres();
    }



    @PostMapping("/genres/")
    public Genre createGenre(@RequestBody Genre genreObject) {
        System.out.println();
        return genreService.createGenre(genreObject);


    }

    @GetMapping("/genres/{genreId}/")
    public Optional<Genre> getGenre(@PathVariable(value = "genreId") Long genreId) {
        return genreService.getGenre(genreId);


    }



    @PutMapping("/genres/{genreId}/")
    public Genre updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody Genre genreObject){
        System.out.println("calling updateGenre ===>");
        return genreService.updateGenre(genreId, genreObject);
    }


    @DeleteMapping("/genres/{genreId}/")
    public String deleteGenre(@PathVariable(value = "genreId") Long genreId){
        System.out.println("calling deleteGenre ===>");
        return genreService.deleteGenre(genreId);


    }




    @PostMapping("/genres/{genreId}/videogames/")
    public Videogame createGenreVideogame(@PathVariable(value = "genreId") Long genreId, @RequestBody Videogame videogameObject){
        System.out.println("calling createGenreVideogame===>");

        return genreService.createGenreVideogame(genreId, videogameObject);
    }

    @GetMapping("/genres/{genreId}/videogames/")
    public List<Videogame> getGenreVideogames(@PathVariable(value = "genreId") Long genreId){
        return genreService.getGenreVideogames(genreId);
    }

    @GetMapping("/genres/{genreId}/videogames/{videogameId}/")
    public Videogame getGenreVideogame(@PathVariable(value = "genreId") Long genreId, @PathVariable(value = "videogameId") Long videogameId){
        return genreService.getGenreVideogame(genreId, videogameId);
    }

    @PutMapping("/genres/{genreId}/videogames/{videogameId}/")
    public Videogame updateGenreVideogame(@PathVariable(value = "genreId") Long genreId, @PathVariable(value = "videogameId") Long videogameId, @RequestBody Videogame videogameObject){
        System.out.println("calling updateGenreVideogame ===>");
        return genreService.updateGenreVideogame(genreId, videogameId, videogameObject);
    }

    @DeleteMapping("/genres/{genreId}/videogames/{videogameId}/")
    public ResponseEntity<HashMap> deleteGenreVideogame(
            @PathVariable(value = "genreId") Long genreId, @PathVariable(value = "videogameId") Long videogameId) {
        System.out.println("calling getGenreVideogame ==>");
        genreService.deleteGenreVideogame(genreId, videogameId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "videogame with id: " + videogameId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }

}
