package challenge;


import challenge.Jogador.RescisaoComparator;
import java.io.File; 
import java.io.FileNotFoundException;  
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;


public class Main {
            
        

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
            List<Jogador> jogadoresFifa = readFile();
            List<String> nacionalidade = new ArrayList<>();
            for(Jogador jogador : jogadoresFifa){
                if(!nacionalidade.contains(jogador.getNacionalidade()) && !jogador.getNacionalidade().equals("")) nacionalidade.add(jogador.getNacionalidade());
            }
            return nacionalidade.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
            List<Jogador> jogadoresFifa = readFile();
            List<String> clube = new ArrayList<>();
            for(Jogador jogador : jogadoresFifa){
                if(!clube.contains(jogador.getClube()) && !jogador.getClube().equals("")) clube.add(jogador.getClube());
            }
            return clube.size();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
            List<Jogador> jogadoresFifa = readFile();
            List<String> nome = new ArrayList<>();
            int count = 0;
            for(Jogador jogador : jogadoresFifa){
                if(count++ == 20) break;
                nome.add(jogador.getNome());
            }
            return nome;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
            List<Jogador> jogadoresFifa = readFile();
            List<String> topRescisao = new ArrayList();
            Jogador[] jogadoresSorted = (Jogador[]) jogadoresFifa.toArray(new Jogador[jogadoresFifa.size()]);
            Arrays.sort(jogadoresSorted, new RescisaoComparator());

            for (int i = 0; i < Math.min(10, jogadoresFifa.size()); i++) {
                topRescisao.add(jogadoresSorted[i].getNome());
            }
            return topRescisao;
	}
            
        
	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
            List<Jogador> jogadoresFifa = readFile();
            List<String> topIdade = new ArrayList();
            Jogador[] jogadoresSorted = (Jogador[]) jogadoresFifa.toArray(new Jogador[jogadoresFifa.size()]);
            Arrays.sort(jogadoresSorted, new Jogador.idadeComparator());

            for (int i = 0; i < Math.min(10, jogadoresFifa.size()); i++) {
                topIdade.add(jogadoresSorted[i].getNome());
            }
            return topIdade;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
            List<Jogador> jogadoresFifa = readFile();
            
            Map<Integer, Integer> idade = new HashMap<>();
            Integer chave = 0;
            Integer valor = 0;
            for(Jogador jogador : jogadoresFifa){
                chave = jogador.getIdade();
                if (idade.containsKey(chave)){
                    valor = idade.get(chave) + 1;
                    idade.put(chave, valor);
                } else idade.put(chave, 1);
            }
            return idade;
	}
        
        public List<Jogador> readFile(){
            List<Jogador> jogadoresFifa = new ArrayList<>();
            List<String> itens = new ArrayList<>();
            List<String[]> jogadores = new ArrayList<>();
        
            try {
                URL url = getClass().getClassLoader().getResource("data.csv");
                File arquivo = new File(url.getPath());
                Scanner teclado = new Scanner(arquivo);
                
                while (teclado.hasNextLine()) {
                String[] linha = teclado.nextLine().split(",");
                if(linha[0].toString().equals("ID")){
                    for(String s : linha){
                        itens.add(s);
                    }
                }
                else jogadores.add(linha);
            }
            teclado.close();
            } catch (FileNotFoundException e) {
                
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
            String nome, nacionalidade, clube;
            BigDecimal rescisao, salario;
            LocalDate nascimento;
            int idade;
            
            for(String[] string : jogadores){                
                nome = string[itens.indexOf("full_name")];
                nacionalidade = string[itens.indexOf("nationality")];
                clube = string[itens.indexOf("club")];
                if(string[itens.indexOf("eur_release_clause")].isEmpty()){
                    rescisao = new BigDecimal(String.valueOf(0));
                } else rescisao = new BigDecimal(string[itens.indexOf("eur_release_clause")]);
                salario = new BigDecimal(string[itens.indexOf("eur_wage")]);
                idade = new Integer(string[itens.indexOf("age")]);
                String[] data = string[itens.indexOf("birth_date")].split("-");
                nascimento = LocalDate.of(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2]));
                                
                Jogador j = new Jogador(nome, nacionalidade, clube, rescisao, salario, nascimento, idade);
                jogadoresFifa.add(j);
            }
            
            return jogadoresFifa;
        }
        

}


