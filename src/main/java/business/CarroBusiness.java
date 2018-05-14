package business;

import java.util.List;

import model.Carro;

public class CarroBusiness {

	public Double calcularValorTotal(List<Carro> carros) {
		Double valorTotal = 0D;

		for (Carro carro : carros) {
			valorTotal += carro.getValor();
		}

		return valorTotal;
	}

}
