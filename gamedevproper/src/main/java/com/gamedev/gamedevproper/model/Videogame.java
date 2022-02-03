package com.gamedev.gamedevproper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "videogames")
public class Videogame {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean multiplayer;

    @Column
    private boolean dlc;

    @Column
    private int criticScore;

    @Column
    private boolean isReleased;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Videogame() {
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", multiplayer=" + multiplayer +
                ", dlc=" + dlc +
                ", criticScore=" + criticScore +
                ", isReleased=" + isReleased +
                '}';
    }

    public Videogame(Long id, String title, String description, boolean multiplayer, boolean dlc, int criticScore, boolean isReleased) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.multiplayer = multiplayer;
        this.dlc = dlc;
        this.criticScore = criticScore;
        this.isReleased = isReleased;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    public boolean getDlc() {
        return dlc;
    }

    public void setDlc(boolean dlc) {
        this.dlc = dlc;
    }

    public int getCriticScore() {
        return criticScore;
    }

    public void setCriticScore(int criticScore) {
        this.criticScore = criticScore;
    }

    public boolean getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(boolean isReleased) {
        this.isReleased = isReleased;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
