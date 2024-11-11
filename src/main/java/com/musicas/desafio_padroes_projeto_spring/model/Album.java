package com.musicas.desafio_padroes_projeto_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Album {
    @Id
    private String id;
    private String name;
    private String album_type;
    private Integer total_tracks;
    private String release_date;
    @JsonProperty("artists")
    @OneToMany
    private ArrayList<Artista> artists;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public void setAlbum_type(String album_type) {
        this.album_type = album_type;
    }

    public Integer getTotal_tracks() {
        return total_tracks;
    }

    public void setTotal_tracks(Integer total_tracks) {
        this.total_tracks = total_tracks;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public ArrayList<Artista> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artista> artists) {
        this.artists = artists;
    }
}
