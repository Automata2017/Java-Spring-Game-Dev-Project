package com.gamedev.gamedevproper.repository;

import com.gamedev.gamedevproper.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    Genre findByName(String genreName);
    List<Genre> findByUserId(Long userId);
    Genre findByUserIdAndName(Long userId, String name);
    Genre findByIdAndUserId (Long genreId, Long userId);

}
