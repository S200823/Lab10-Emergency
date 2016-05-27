package it.polito.tdp.emergency.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.emergency.db.FieldHospitalDAO;
import it.polito.tdp.emergency.simulation.Arrivo;
import it.polito.tdp.emergency.simulation.Core;
import it.polito.tdp.emergency.simulation.Dottore;
import it.polito.tdp.emergency.simulation.Evento;
import it.polito.tdp.emergency.simulation.Paziente;

public class Model {

	Core simulatore = new Core();
	FieldHospitalDAO dao;
	List<Paziente> pazienti;
	List<Arrivo> arrivi;
	List<Dottore> dottori;

	public Model() {
		dao = new FieldHospitalDAO();
		pazienti = dao.getAllPazienti();
		arrivi = dao.getAllArrivals(pazienti);
		dottori = new ArrayList<Dottore>();
	}

	public void addDottore(String nomeDottore, int oreSfalsamento) {
		Dottore dottore = new Dottore(nomeDottore, oreSfalsamento, null);
		System.out.println(dottore);
		dottori.add(dottore);
	}

	public String simula() {
		simulatore.setMediciDisponibili(8);
		for (Paziente p : pazienti)
			simulatore.aggiungiPaziente(p);
		for (Arrivo a : arrivi)
			simulatore.aggiungiEvento(new Evento(a.getTime(), Evento.TipoEvento.PAZIENTE_ARRIVA, a.getPaziente()));
		return simulatore.simula();
	}
}
