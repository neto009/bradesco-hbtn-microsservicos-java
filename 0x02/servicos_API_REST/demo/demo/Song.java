package com.example.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Song {
    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Song() {}

    public Song(Integer id, String nome, String artista, String album, String anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
    }
}
