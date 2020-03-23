package challenge;

import java.util.ArrayList;
import java.util.List;
import static java.util.concurrent.ThreadLocalRandom.current;

public class Estacionamento {

    List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
      if(carros.size() == 10){
          for(Carro c : carros){
              if (c.getMotorista().getIdade() <= 55){
                  carros.remove(c);
                  break;
              }
          }
          if(carros.size() == 9) carros.add(carro);
          else throw new EstacionamentoException("Estacionamento cheio (todos os motoristas tem mais de 55 anos)");
      }
      else carros.add(carro);
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }

}
