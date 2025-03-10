package com.booleanuk.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "videogames")
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "studio")
    private String studio;

    @Column(name = "rating")
    private String rating;

    @Column(name = "num_of_players")
    private int numberOfPlayers;

    @Column(name = "genre")
    private String genre;

    @OneToOne(mappedBy = "videoGame")
    @JsonIgnoreProperties("videoGame")
    private Loan loan;

    public VideoGame(String title, String studio, String rating, int numberOfPlayers, String genre) {
        this.title = title;
        this.studio = studio;
        this.rating = rating;
        this.numberOfPlayers = numberOfPlayers;
        this.genre = genre;
    }
}
