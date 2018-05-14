package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import business.CarroBusiness;
import model.Carro;

@ViewScoped
@ManagedBean
public class CarroController {

	private Carro carro;

	private boolean aba = Boolean.TRUE;

	private Double valorTotalCarros = 0D;

	private List<Carro> carros = new ArrayList<>();

	private CarroBusiness carroBusiness = new CarroBusiness();

	@PostConstruct
	public void initialize() {
		novoCarro();
	}

	public void toggle() {
		aba = !aba;
	}

	public String validaAno(Carro carro) {
		return carro.getFabricacao() == 2017 ? "vermelho" : "verde";
	}

	public void novoCarro() {
		carro = new Carro();
	}

	public void calcularTotalCarros() {
		valorTotalCarros = carroBusiness.calcularValorTotal(carros);
	}

	public void salvar() {

		if (!carros.isEmpty() && carros.contains(carro)) {
			carros.remove(carro);
		}

		carros.add(carro);
		calcularTotalCarros();
		novoCarro();
		addMessage("Salvo", "Carro salvo com sucesso!");
	}

	public void editar(ActionEvent event) {
		setCarro((Carro) event.getComponent().getAttributes().get("carroSelecionado"));
	}

	public void excluir(ActionEvent event) {
		carros.remove((Carro) event.getComponent().getAttributes().get("carroExcluido"));
		calcularTotalCarros();
	}

	public void addMessage(String mensagem, String detalhe) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, detalhe);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public Double getValorTotalCarros() {
		return valorTotalCarros;
	}

	public void setValorTotalCarros(Double valorTotalCarros) {
		this.valorTotalCarros = valorTotalCarros;
	}

	public boolean isAba() {
		return aba;
	}

	public void setAba(boolean aba) {
		this.aba = aba;
	}

}
