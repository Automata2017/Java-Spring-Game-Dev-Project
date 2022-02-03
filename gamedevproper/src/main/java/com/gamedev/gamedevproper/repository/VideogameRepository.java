package com.gamedev.gamedevproper.repository;

import com.gamedev.gamedevproper.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long> {

    List<Videogame> findByGenre(Long videogameId);
    Videogame findByNameAndUserId (String name, Long userId);
    Videogame findByNameAndUserIdAndIdIsNot (String name, Long userId, Long videogameId);
}
