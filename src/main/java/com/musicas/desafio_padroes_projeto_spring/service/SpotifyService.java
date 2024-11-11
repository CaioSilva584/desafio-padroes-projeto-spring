package com.musicas.desafio_padroes_projeto_spring.service;

import com.musicas.desafio_padroes_projeto_spring.model.Album;
import com.musicas.desafio_padroes_projeto_spring.model.Artista;
import com.musicas.desafio_padroes_projeto_spring.model.Musica;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spotify", url = "https://api.spotify.com/v1")
public interface SpotifyService {

    @GetMapping("/albums/{id}")
    Album consultarAlbum(@PathVariable("id") String id);

    @GetMapping("/artists/{id}")
    Artista consultarArtista(@PathVariable("id") String id);

    @GetMapping("/tracks/{id}")
    Musica consultarMusica(@PathVariable("id") String id);
}
