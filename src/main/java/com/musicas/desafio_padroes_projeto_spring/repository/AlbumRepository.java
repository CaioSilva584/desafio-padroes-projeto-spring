package com.musicas.desafio_padroes_projeto_spring.repository;


import com.musicas.desafio_padroes_projeto_spring.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, String> {

}
