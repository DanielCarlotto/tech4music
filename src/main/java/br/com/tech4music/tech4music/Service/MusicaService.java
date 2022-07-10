package br.com.tech4music.tech4music.Service;

import java.util.List;
import java.util.Optional;

import br.com.tech4music.tech4music.Compartilhado.MusicaDto;
import br.com.tech4music.tech4music.View.model.MusicaResponse;

public interface MusicaService {
    
    MusicaDto criarMusica(MusicaDto musica);
    List<MusicaDto> obterTudo();
    Optional<MusicaDto> obterPorId(String id);
    MusicaDto atualizarMusica(String id, MusicaResponse musicaResponse);
    void removerMusica(String id);
    MusicaDto atualizarMusica(String id, MusicaDto musicaDto);
}
