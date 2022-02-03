package com.gamedev.gamedevproper.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String profileDescription;

    public UserProfile(Long id, String firstName, String lastName, String profileDescription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileDescription = profileDescription;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;



}
