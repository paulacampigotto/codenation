package challenge;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;


public class Jogador {
    
    private String nome, nacionalidade, clube;
    private BigDecimal rescisao, salario;
    private LocalDate nascimento;
    private int idade;
    
    public Jogador (String nome, String nacionalidade, String clube, BigDecimal rescisao, BigDecimal salario, LocalDate nascimento, int idade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.clube = clube;
        this.rescisao = rescisao;
        this.salario = salario;
        this.nascimento = nascimento;
        this.idade = idade;
    }
    
    public static class RescisaoComparator implements Comparator<Jogador>{
        public int compare(Jogador a, Jogador b){
            return b.getRescisao().compareTo(a.getRescisao());
        }
    }
    
    public static class idadeComparator implements Comparator<Jogador>{
        public int compare(Jogador a, Jogador b){
            if(b.getNascimento().equals(a.getNascimento())){
                return a.getSalario().compareTo(b.getSalario());
            }
            return a.getNascimento().compareTo(b.getNascimento());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public BigDecimal getRescisao() {
        return rescisao;
    }

    public void setRescisao(BigDecimal rescisao) {
        this.rescisao = rescisao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
