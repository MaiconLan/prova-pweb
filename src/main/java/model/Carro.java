package model;

public class Carro {

	private Long idCarro;
	private String marca;
	private String modelo;
	private String placa;
	private Integer fabricacao;
	private Double valor;

	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Integer fabricacao) {
		this.fabricacao = fabricacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCarro == null) ? 0 : idCarro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (idCarro == null) {
			if (other.idCarro != null)
				return false;
		} else if (!idCarro.equals(other.idCarro))
			return false;
		return true;
	}

}
