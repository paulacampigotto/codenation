package challenge;

import java.util.Objects;


public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) throws EstacionamentoException, NullPointerException, IllegalArgumentException {
        
        if(nome.isEmpty() || nome == null || nome == "") throw new NullPointerException();   
        if(habilitacao.isEmpty() || habilitacao == null || habilitacao == "") throw new NullPointerException();
        if(idade < 0) throw new IllegalArgumentException();     
        if(idade < 18) throw new EstacionamentoException("Idade insuficiente");
        if(pontos < 0) throw new IllegalArgumentException();
        if(pontos > 20) throw new EstacionamentoException("CNH suspensa");
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
        
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;
        

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) throws NullPointerException {
            if(nome.isEmpty() || nome == null || nome == "") throw new NullPointerException();
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) throws EstacionamentoException, IllegalArgumentException {
            if(idade < 0) throw new IllegalArgumentException();
            if(idade < 18) throw new EstacionamentoException("Idade insuficiente");
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) throws EstacionamentoException, IllegalArgumentException {
            if(pontos < 0) throw new IllegalArgumentException();
            if(pontos > 20) throw new EstacionamentoException("CNH suspensa");
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) throws NullPointerException {
            if(habilitacao.isEmpty() || habilitacao == null || habilitacao == "") throw new NullPointerException();
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() throws NullPointerException {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
