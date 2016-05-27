//////////////////////////////////////////////////////////////////-*-java-*-//
//             // Classroom code for "Tecniche di Programmazione"           //
//   #####     // (!) Giovanni Squillero <giovanni.squillero@polito.it>     //
//  ######     //                                                           //
//  ###   \    // Copying and distribution of this file, with or without    //
//   ##G  c\   // modification, are permitted in any medium without royalty //
//   #     _\  // provided this notice is preserved.                        //
//   |   _/    // This file is offered as-is, without any warranty.         //
//   |  _/     //                                                           //
//             // See: http://bit.ly/tecn-progr                             //
//////////////////////////////////////////////////////////////////////////////

package it.polito.tdp.emergency.simulation;

public class Paziente implements Comparable<Paziente> {

	public enum StatoPaziente {
		ROSSO, GIALLO, VERDE, BIANCO, IN_CURA, SALVO, NERO
	};

	private int id;
	private String name;

	private StatoPaziente stato;

	public Paziente(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Paziente(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paziente other = (Paziente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public StatoPaziente getStato() {
		return stato;
	}

	public void setStato(String triage) {
		// valueOf() would have been simpler, but CaSe SeNsItIvE
		if(triage.compareToIgnoreCase("Black")==0)
			this.stato = StatoPaziente.NERO;
		else if(triage.compareToIgnoreCase("Red")==0)
			this.stato = StatoPaziente.ROSSO;
		else if(triage.compareToIgnoreCase("Yellow")==0)
			this.stato = StatoPaziente.GIALLO;
		else if(triage.compareToIgnoreCase("Green")==0)
			this.stato = StatoPaziente.VERDE;
		else if(triage.compareToIgnoreCase("White")==0)
			this.stato = StatoPaziente.BIANCO;
		else if(triage.compareToIgnoreCase("In_cura")==0)
			this.stato = StatoPaziente.IN_CURA;
		else if(triage.compareToIgnoreCase("Salvo")==0)
			this.stato = StatoPaziente.SALVO;
		else
			throw new ClassCastException("Unknown triage: \"" + triage + "\"");
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Paziente [nome=" + name + ", stato=" + stato + "]";
	}

	@Override
	public int compareTo(Paziente arg0) {
		return Integer.compare(this.getStato().ordinal(), arg0.getStato().ordinal());
	}

}
