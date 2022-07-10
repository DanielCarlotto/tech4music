package br.com.tech4music.tech4music.View.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class MusicaRequest {

    private String id;
    private String titulo;

    @NotBlank(message = "O nome do artista nao pode estra em branco")
    @NotEmpty(message = "O nome do artista nao pode estar vazio")
    private String artista;
    private String album;
    private String genero;
    private int anoLancamento;
    private String compositor;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompostior() {
        return compositor;
    }
    public void setCompostior(String compostior) {
        this.compositor = compostior;
    }
    
    
}
