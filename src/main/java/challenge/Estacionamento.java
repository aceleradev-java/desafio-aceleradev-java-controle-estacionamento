package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null) {
            throw  new EstacionamentoException("Não é permitido carro autonomo");
        }

        if (carro.getMotorista().getIdade() < 18) {
            throw new EstacionamentoException("O motorista é de menor");
        }
        
        if (carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("O motorista está sem pontos na carteira");
        }
        
        if (carros.size() == 10) {
            if (carrosEstacionadosComMotoristasJovens().isEmpty()) {
                throw new EstacionamentoException("Vaga não disponível, todas vagas possuem idosos");
            }
            carros.remove(carrosEstacionadosComMotoristasJovens().get(0));
        }
        carros.add(carro);
    }
    
    
    private List<Carro> carrosEstacionadosComMotoristasJovens() {
        List<Carro> carrosComMotoristasJovens = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getMotorista().getIdade() <= 55) {
                carrosComMotoristasJovens.add(carro);
            }
        }
        return carrosComMotoristasJovens;
    }
    
    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
