package br.com.tech4music.tech4music.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4music.tech4music.Model.Musica;


public interface MusicaRepository extends MongoRepository<Musica, String>{
    
}
