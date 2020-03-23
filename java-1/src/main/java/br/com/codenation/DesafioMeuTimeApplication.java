package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.Jogador.JogadorComparator;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private List<Time> times = new ArrayList<>();
    private List<Jogador> jogadores = new ArrayList<>();

    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao,
            String corUniformePrincipal, String corUniformeSecundario) throws IdentificadorUtilizadoException {
        if (getTimeById(id) == null) {
            Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
            times.add(time);
        } else throw new IdentificadorUtilizadoException();
    }

    @Desafio("incluirJogador")
    public void incluirJogador(Long id, Long idTime, String nome,
            LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) throws IdentificadorUtilizadoException, TimeNaoEncontradoException {
        if (getJogadorById(id) == null) {
            if (getTimeById(idTime) != null) {
                Jogador jogador = new Jogador(id, idTime, nome, dataNascimento,
                        nivelHabilidade, salario);
                getJogadores().add(jogador);
                getTimeById(idTime).addJogadores(jogador);
            } else throw new TimeNaoEncontradoException();
        } else throw new IdentificadorUtilizadoException();
    }

    @Desafio("definirCapitao")
    public void definirCapitao(Long idJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = getJogadorById(idJogador);
        if (jogador != null) {
            Time time = getTimeById(jogador.getIdTime());
            time.setCapitao(jogador);
        } else throw new JogadorNaoEncontradoException();
    }

    @Desafio("buscarCapitaoDoTime")
    public Long buscarCapitaoDoTime(Long idTime) throws TimeNaoEncontradoException, CapitaoNaoInformadoException {
        Time time = getTimeById(idTime);
        if (time != null) {
            if (time.getCapitao() != null) {
                return time.getCapitao().getId();
            } else throw new CapitaoNaoInformadoException();
        } else throw new TimeNaoEncontradoException();
    }

    @Desafio("buscarNomeJogador")
    public String buscarNomeJogador(Long idJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = getJogadorById(idJogador);
        if (jogador != null) {
            return jogador.getNome();
        }
        
        throw new JogadorNaoEncontradoException();
    }

    @Desafio("buscarNomeTime")
    public String buscarNomeTime(Long idTime) throws TimeNaoEncontradoException {
        Time time = getTimeById(idTime);
        if (time != null) {
            return time.getNome();
        }
        
        throw new TimeNaoEncontradoException();
    }

    @Desafio("buscarJogadoresDoTime")
    public List<Long> buscarJogadoresDoTime(Long idTime) throws TimeNaoEncontradoException {
        List<Long> idJogadores = new ArrayList();
        Time time = getTimeById(idTime);
        if (time != null) {
            for(Jogador jogador : time.getJogadores()){
                idJogadores.add(jogador.getId());
            }
            Collections.sort(idJogadores);
            
            return idJogadores;
        }
        
        throw new TimeNaoEncontradoException();
    }

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        Time time = getTimeById(idTime);
        if (time != null) {
            List<Jogador> jogadores2 = time.getJogadores();
            Integer maior = 0;
            Long melhorJogador = null;
            
            for(Jogador jogador : jogadores2){
                if (jogador.getNivelHabilidade() > maior) {
                    maior = jogador.getNivelHabilidade();
                    melhorJogador = jogador.getId();
                }
            }
            
            return melhorJogador;
        }
        
        throw new TimeNaoEncontradoException();
    }

    @Desafio("buscarJogadorMaisVelho")
    public Long buscarJogadorMaisVelho(Long idTime) {
        Time t = getTimeById(idTime);
        if (t != null) {
            List<Jogador> jogadores2 = t.getJogadores();
            LocalDate maior = LocalDate.MAX;
            Long maisVelho = null;
            
            for(Jogador jogador : jogadores2){
                if (jogador.getDataNascimento().isBefore(maior)) {
                    maior = jogador.getDataNascimento();
                    maisVelho = jogador.getId();
                } else if (jogador.getDataNascimento().isEqual(maior)) {
                    maisVelho = Math.min(maisVelho, jogador.getId());
                }
            }
            
            return maisVelho;
        }
        
        throw new TimeNaoEncontradoException();
    }

    @Desafio("buscarTimes")
    public List<Long> buscarTimes() {
        List<Long> timesId = new ArrayList<>();
        times.forEach((time) -> {
            timesId.add(time.getId());
        });
        Collections.sort(timesId);
        
        return timesId;
    }

    @Desafio("buscarJogadorMaiorSalario")
    public Long buscarJogadorMaiorSalario(Long idTime) throws TimeNaoEncontradoException, TimeNaoEncontradoException {
        Time time = getTimeById(idTime);
        if (time != null) {
            List<Jogador> jogadores2 = time.getJogadores();
            BigDecimal maior = BigDecimal.ZERO;
            Long maiorSalario = null;
            for(Jogador jogador : jogadores2){
                if (jogador.getSalario().compareTo(maior) > 0) {
                    maior = jogador.getSalario();
                    maiorSalario = jogador.getId();
                } else if (jogador.getSalario().equals(maior)) {
                    maiorSalario = Math.min(jogador.getId(), maiorSalario);
                }
            }
            return maiorSalario;
        }
        throw new TimeNaoEncontradoException();
    }

    @Desafio("buscarSalarioDoJogador")
    public BigDecimal buscarSalarioDoJogador(Long idJogador) throws JogadorNaoEncontradoException {
        Jogador j = getJogadorById(idJogador);
        if (j != null) {
            return j.getSalario();
        }
        
        throw new JogadorNaoEncontradoException();
    }

    @Desafio("buscarTopJogadores")
    public List<Long> buscarTopJogadores(Integer top) {
        List<Long> tops = new ArrayList();
        Jogador[] jogadoresSorted = (Jogador[]) jogadores.toArray(new Jogador[jogadores.size()]);
        Arrays.sort(jogadoresSorted, new JogadorComparator());
        
        for (int i = 0; i < Math.min(top, jogadores.size()); i++) {
            tops.add(jogadoresSorted[i].getId());
        }
        Collections.sort(tops);
        return tops;
    }

    @Desafio("buscarCorCamisaTimeDeFora")
    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
        Time casa = getTimeById(timeDaCasa);
        Time fora = getTimeById(timeDeFora);

        if (casa.getCorUniformePrincipal().equals(fora.getCorUniformePrincipal())) {
            return fora.getCorUniformeSecundario();
        }
        
        return fora.getCorUniformePrincipal();
    }

    private Time getTimeById(Long id) {
        for (Time time : times) {
            if (time.getId().equals(id)) {
                return time;
            }
        }

        return null;
    }

    private Jogador getJogadorById(Long id) {
        for (Jogador jogador : jogadores) {
            if (jogador.getId().equals(id)) {
                return jogador;
            }
        }

        return null;
    }

    public List getJogadores() {
        return jogadores;
    }

    public void setJogadores(List jogadores) {
        this.jogadores = jogadores;
    }


   
}
