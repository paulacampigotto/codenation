package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Time {
    private Long id;
    private String nome; 
    private String corUniformePrincipal; 
    private String corUniformeSecundario;
    private LocalDate dataCriacao;
    private List jogadores;
    private Jogador capitao;
    
    public Time(Long id, String nome, LocalDate dataCriacao, 
            String corUniformePrincipal, String corUniformeSecundario){
        this.jogadores = new ArrayList<Jogador>();
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }
    
    public void addJogadores(Jogador j){
        getJogadores().add(j);
    }

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

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
       

    public Jogador getCapitao() {
        return capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List jogadores) {
        this.jogadores = jogadores;
    }
}
