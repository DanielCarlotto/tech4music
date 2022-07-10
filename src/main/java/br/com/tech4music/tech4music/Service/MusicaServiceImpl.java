package br.com.tech4music.tech4music.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4music.tech4music.Compartilhado.MusicaDto;
import br.com.tech4music.tech4music.Model.Musica;
import br.com.tech4music.tech4music.Repository.MusicaRepository;
import br.com.tech4music.tech4music.View.model.MusicaResponse;

@Service
public class MusicaServiceImpl implements MusicaService{
    
    @Autowired
    private MusicaRepository repositorio;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MusicaDto criarMusica (MusicaDto musicaDto) {
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repositorio.save(musica);
        MusicaDto dto = mapper.map(musica, MusicaDto.class);
        return dto;
    }

    @Override
    public List<MusicaDto> obterTudo() {
        List<Musica> list = repositorio.findAll();

        List<MusicaDto> musicaDto =
        list.
        stream().
        map(p -> mapper.map(p, MusicaDto.class)).
        collect(Collectors.toList());
        return musicaDto;
    }

    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        Optional<Musica> musica = repositorio.findById(id);
        if (musica.isPresent()) {
            MusicaDto musicaDto = mapper.map(musica, MusicaDto.class);
            return Optional.of(musicaDto);
        }
        
        return Optional.empty();
    }

    @Override
    public MusicaDto atualizarMusica(String id, MusicaDto musicaDto) {
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica.setId(id);
        musica = repositorio.save(musica);
        MusicaDto dto = mapper.map(musica, MusicaDto.class);

        return dto;
    }

    @Override
    public void removerMusica(String id) {
        repositorio.deleteById(id);
        
        
    }

    @Override
    public MusicaDto atualizarMusica(String id, MusicaResponse musicaResponse) {
        return null;
    }




}
