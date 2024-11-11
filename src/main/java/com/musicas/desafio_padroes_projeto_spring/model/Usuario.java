package com.musicas.desafio_padroes_projeto_spring.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Musica musicaFav;
    @ManyToOne
    private Album albumFav;
    @ManyToOne
    private Artista artistaFav;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Musica getMusicaFav() {
        return musicaFav;
    }

    public void setMusicaFav(Musica musicaFav) {
        this.musicaFav = musicaFav;
    }

    public Album getAlbumFav() {
        return albumFav;
    }

    public void setAlbumFav(Album albumFav) {
        this.albumFav = albumFav;
    }

    public Artista getArtistaFav() {
        return artistaFav;
    }

    public void setArtistaFav(Artista artistaFav) {
        this.artistaFav = artistaFav;
    }
}
