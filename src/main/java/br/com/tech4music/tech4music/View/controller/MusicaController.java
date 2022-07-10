package br.com.tech4music.tech4music.View.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4music.tech4music.Compartilhado.MusicaDto;
import br.com.tech4music.tech4music.Service.MusicaService;
import br.com.tech4music.tech4music.View.model.MusicaRequest;
import br.com.tech4music.tech4music.View.model.MusicaResponse;

@RestController
@RequestMapping("api/musicas")
public class MusicaController {

    @Autowired
    private MusicaService servico;

    ModelMapper mapper = new ModelMapper();
    
    @GetMapping
    public ResponseEntity<List<MusicaResponse>> obterTudo() {
        List<MusicaDto> musicaDto = servico.obterTudo();
        List<MusicaResponse> musicaResponse =
        musicaDto.
        stream().
        map(p -> mapper.map(p, MusicaResponse.class)).
        collect(Collectors.toList());

        return new ResponseEntity<>(musicaResponse,HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaResponse> criarMusica (@RequestBody @Valid MusicaRequest musica) {
        MusicaDto musicaDto = mapper.map(musica, MusicaDto.class);
        musicaDto = servico.criarMusica(musicaDto);;
        MusicaResponse musicaResponse = mapper.map(musicaDto, MusicaResponse.class);
        return new ResponseEntity<>(musicaResponse,HttpStatus.CREATED);

    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<MusicaResponse> obterPorId(@PathVariable String id){
      Optional<MusicaDto> musicaDto = servico.obterPorId(id);
      if (musicaDto.isPresent()){
        MusicaResponse musicaResponse = mapper.map(musicaDto, MusicaResponse.class);
        return new ResponseEntity<>(musicaResponse, HttpStatus.OK);
      }         
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaResponse> atualizarMusica(@PathVariable String id, @RequestBody MusicaRequest musica){
      MusicaDto musicaDto = mapper.map(musica, MusicaDto.class);
      musicaDto = servico.atualizarMusica(id, musicaDto);
      MusicaResponse musicaResponse = mapper.map(musicaDto, MusicaResponse.class);
      return new ResponseEntity<>(musicaResponse,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removerMusica(@PathVariable String id){
      servico.removerMusica(id);
      return new ResponseEntity<>("Deletado com sucesso",HttpStatus.OK);
    }


}
