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

import java.time.LocalDateTime;

public class Evento implements Comparable<Evento> {

	public Paziente getPaziente() {
		return paziente;
	}

	@Override
	public String toString() {
		return "Evento [tempo=" + tempo + ", tipo=" + tipo + ", paziente=" + paziente.getName() + " - "
				+ paziente.getStato() + "]";
	}

	public enum TipoEvento {
		PAZIENTE_ARRIVA, PAZIENTE_GUARISCE, PAZIENTE_MUORE
	}

	protected LocalDateTime tempo;
	protected TipoEvento tipo;
	protected Paziente paziente;

	public LocalDateTime getTempo() {
		return tempo;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public Evento(LocalDateTime time, TipoEvento type, Paziente paziente) {
		super();
		this.tempo = time;
		this.tipo = type;
		this.paziente = paziente;
	}

	@Override
	public int compareTo(Evento arg0) {
		return this.tempo.compareTo(arg0.tempo);
	}

}
