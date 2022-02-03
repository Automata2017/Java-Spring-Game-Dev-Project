package com.gamedev.gamedevproper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Genre() {
    }

    @OneToMany(mappedBy = "genre", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Videogame> videogameList;

    public List<Videogame> getVideogameList(){
        return videogameList;
    }

    public void setVideogameList(List<Videogame> videogameList) {
        this.videogameList = videogameList;
    }

    public Genre(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
