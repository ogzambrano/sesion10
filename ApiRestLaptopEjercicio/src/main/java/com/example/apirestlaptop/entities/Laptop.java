package com.example.apirestlaptop.entities;



import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Laptop{
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String market;
    private String model;
    private LocalDate releaseDate;
    private Boolean online;

    //constructor
    public Laptop() {
    }

    public Laptop(String market, String model, LocalDate releaseDate, Boolean online) {
        this.market = market;
        this.model = model;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    public Laptop(Long id, String market, String model, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.market = market;
        this.model = model;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    //getter y setter

    public Long getId() {
        return id;
    }

    public String getMarket() {
        return market;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
