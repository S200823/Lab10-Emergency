package it.polito.tdp.emergency.simulation;

public class Dottore {

	public enum StatoDottore {
		DOCTOR_INIZIA_TURNO, DOCTOR_FINE_TURNO
	};

	private String nome;
	private int oreSfalsamento;
	private StatoDottore stato;

	public Dottore(String nome, int oreSfalsamento, StatoDottore stato) {
		this.nome = nome;
		this.oreSfalsamento = oreSfalsamento;
		this.stato = stato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getOreSfalsamento() {
		return oreSfalsamento;
	}

	public void setOreSfalsamento(int oreSfalsamento) {
		this.oreSfalsamento = oreSfalsamento;
	}

	public StatoDottore getStato() {
		return stato;
	}

	public void setStato(StatoDottore stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Dottore [nome=" + nome + ", oreSfalsamento=" + oreSfalsamento + ", stato=" + stato + "]";
	}
}
