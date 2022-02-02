package com.gamedev.gamedevproper.repository;

import com.gamedev.gamedevproper.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long> {

}
