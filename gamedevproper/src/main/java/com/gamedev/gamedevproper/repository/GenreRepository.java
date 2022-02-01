package com.gamedev.gamedevproper.repository;

import com.gamedev.gamedevproper.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    Genre findByName(String Category);

}
