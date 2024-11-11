package com.musicas.desafio_padroes_projeto_spring.service.impl;

import com.musicas.desafio_padroes_projeto_spring.model.Album;
import com.musicas.desafio_padroes_projeto_spring.model.Artista;
import com.musicas.desafio_padroes_projeto_spring.model.Musica;
import com.musicas.desafio_padroes_projeto_spring.model.Usuario;
import com.musicas.desafio_padroes_projeto_spring.repository.AlbumRepository;
import com.musicas.desafio_padroes_projeto_spring.repository.ArtistaRepository;
import com.musicas.desafio_padroes_projeto_spring.repository.MusicaRepository;
import com.musicas.desafio_padroes_projeto_spring.repository.UsuarioRepository;
import com.musicas.desafio_padroes_projeto_spring.service.SpotifyService;
import com.musicas.desafio_padroes_projeto_spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistaRepository artistaRepository;
    @Autowired
    private MusicaRepository musicaRepository;
    @Autowired
    private SpotifyService spotifyService;

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.orElse(null);
    }

    @Override
    public void inserir(Usuario usuario) {
        // Aqui são extraídos os códigos informados pelo usuário
        String idAlbum = usuario.getAlbumFav().getId();
        String idArtista = usuario.getArtistaFav().getId();
        String idMusica = usuario.getMusicaFav().getId();

        // Neste tipo de método, sempre lembrar de salvar o objeto novo extraido da API no banco via Repository
        Album albumFav = albumRepository.findById(idAlbum).orElseGet(() -> {
            Album albumNovo = spotifyService.consultarAlbum(idAlbum);
            albumRepository.save(albumNovo);
            return albumNovo;
        });

        // Para cada um, é verificado se o objeto já existe no banco, caso contrário, ele é requisitado na API
        Artista artistaFav = artistaRepository.findById(idArtista).orElseGet(() -> {
            Artista artistaNovo = spotifyService.consultarArtista(idArtista);
            artistaRepository.save(artistaNovo);
            return artistaNovo;
        });

        Musica musicaFav = musicaRepository.findById(idMusica).orElseGet(() -> {
            Musica musicaNova = spotifyService.consultarMusica(idMusica);
            musicaRepository.save(musicaNova);
            return musicaNova;
        });

        // Os objetos informados são adicionados ao usuario
        usuario.setAlbumFav(albumFav);
        usuario.setArtistaFav(artistaFav);
        usuario.setMusicaFav(musicaFav);

        usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioAlterado = usuarioRepository.findById(id);

        if (usuarioAlterado.isPresent()) {
            inserir(usuario);
        } else {
            throw new NullPointerException("Não foi possível encontrar o usuário informado");
        }
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
