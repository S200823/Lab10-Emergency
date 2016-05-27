package it.polito.tdp.emergency.simulation;

import java.time.LocalDateTime;

public class Arrivo {
	
	private LocalDateTime time;
	private Paziente paziente;
	private String triage;
	
	public Arrivo(LocalDateTime time, Paziente paziente, String triage) {
		this.time = time;
		this.paziente = paziente;
		this.triage = triage;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public String getTriage() {
		return triage;
	}

	public void setTriage(String triage) {
		this.triage = triage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paziente == null) ? 0 : paziente.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((triage == null) ? 0 : triage.hashCode());
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
		Arrivo other = (Arrivo) obj;
		if (paziente == null) {
			if (other.paziente != null)
				return false;
		} else if (!paziente.equals(other.paziente))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (triage == null) {
			if (other.triage != null)
				return false;
		} else if (!triage.equals(other.triage))
			return false;
		return true;
	}
}
