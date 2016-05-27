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

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Core {
	public int getPazientiSalvati() {
		return pazientiSalvati;
	}

	public int getPazientiPersi() {
		return pazientiPersi;
	}

	int pazientiSalvati = 0;
	int pazientiPersi = 0;
	String textOut = "";

	Queue<Evento> listaEventi = new PriorityQueue<Evento>();
	Map<Integer, Paziente> pazienti = new HashMap<Integer, Paziente>();
	int mediciDisponibili = 0;
	Queue<Paziente> pazientiInAttesa = new PriorityQueue<Paziente>();

	public int getMediciDisponibili() {
		return mediciDisponibili;
	}

	public void setMediciDisponibili(int mediciDisponibili) {
		this.mediciDisponibili = mediciDisponibili;
	}

	public void aggiungiEvento(Evento e) {
		listaEventi.add(e);
	}

	public void aggiungiPaziente(Paziente p) {
		pazienti.put(p.getId(), p);
	}

	public String simula() {
		textOut += "***** INIZIO SIMULAZIONE *****\n";
		while (!listaEventi.isEmpty()) {
			Evento e = listaEventi.remove();
			switch (e.getTipo()) {
			case PAZIENTE_ARRIVA:
				textOut += "\n\tArrivo paziente:  " + e;
				pazientiInAttesa.add(e.getPaziente());
				switch (e.getPaziente().getStato()) {
				case BIANCO:
					break;
				case GIALLO:
					if (isMedicoDisponibile()) {
						textOut += "\n\tInizio cura:          " + e;
						this.aggiungiEvento(new Evento(e.getTempo().plusMinutes(30),
								Evento.TipoEvento.PAZIENTE_GUARISCE, e.getPaziente()));
						mediciDisponibili--;
					} else
						this.aggiungiEvento(new Evento(e.getTempo().plusHours(6), Evento.TipoEvento.PAZIENTE_MUORE,
								e.getPaziente()));
					break;
				case ROSSO:
					if (isMedicoDisponibile()) {
						textOut += "\n\tInizio cura:          " + e;
						this.aggiungiEvento(new Evento(e.getTempo().plusMinutes(30),
								Evento.TipoEvento.PAZIENTE_GUARISCE, e.getPaziente()));
						mediciDisponibili--;
					} else
						this.aggiungiEvento(new Evento(e.getTempo().plusHours(1), Evento.TipoEvento.PAZIENTE_MUORE,
								e.getPaziente()));
					break;
				case VERDE:
					if (isMedicoDisponibile()) {
						textOut += "\n\tInizio cura:          " + e;
						this.aggiungiEvento(new Evento(e.getTempo().plusMinutes(30),
								Evento.TipoEvento.PAZIENTE_GUARISCE, e.getPaziente()));
						mediciDisponibili--;
					} else
						this.aggiungiEvento(new Evento(e.getTempo().plusHours(12), Evento.TipoEvento.PAZIENTE_MUORE,
								e.getPaziente()));
					break;
				default:
					System.err.println("Panik!");
				}
				break;
			case PAZIENTE_GUARISCE:
					textOut += "\n\tPaziente salvato: " + e;
					e.getPaziente().setStato("Salvo");
					mediciDisponibili++;
					pazientiSalvati++;
				break;
			case PAZIENTE_MUORE:
					pazientiPersi++;
					e.getPaziente().setStato("Black");
					textOut += "\n\tPaziente morto:  " + e;
				break;
			default:
				System.err.println("Panik!");
			}
		}
		textOut += "\n\n***** FINE SIMULAZIONE *****\n";
		textOut += "\n\tPazienti salvati: " + pazientiSalvati + ";";
		textOut += "\n\tPazienti persi: " + pazientiPersi + ".";
		return textOut;
	}

	private boolean isMedicoDisponibile() {
		if (mediciDisponibili > 0)
			return true;
		else
			return false;
	}
}
