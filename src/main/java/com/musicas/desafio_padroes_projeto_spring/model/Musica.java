package com.musicas.desafio_padroes_projeto_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Musica {

    @Id
    private String id;
    @ManyToOne
    private Album album;
    private Integer disc_number;
    private Integer duration_ms;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getDisc_number() {
        return disc_number;
    }

    public void setDisc_number(Integer disc_number) {
        this.disc_number = disc_number;
    }

    public Integer getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(Integer duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
