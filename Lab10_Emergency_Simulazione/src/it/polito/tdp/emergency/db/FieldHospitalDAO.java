////////////////////////////////////////////////////////////////////////////////
//             //                                                             //
//   #####     // Field hospital simulator                                    //
//  ######     // (!) 2013 Giovanni Squillero <giovanni.squillero@polito.it>  //
//  ###   \    //                                                             //
//   ##G  c\   // Field Hospital DAO                                          //
//   #     _\  // Test with MariaDB 10 on win                                 //
//   |   _/    //                                                             //
//   |  _/     //                                                             //
//             // 03FYZ - Tecniche di programmazione 2012-13                  //
////////////////////////////////////////////////////////////////////////////////

package it.polito.tdp.emergency.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.emergency.simulation.Arrivo;
import it.polito.tdp.emergency.simulation.Paziente;

public class FieldHospitalDAO {

	public List<Paziente> getAllPazienti() {
		final String sql = "SELECT * FROM patients, arrivals WHERE patients.id=arrivals.patient";
		List<Paziente> pazienti = new ArrayList<Paziente>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String triage = res.getString("triage");
				Paziente p = new Paziente(id, name);
				p.setStato(triage);
				pazienti.add(p);
			}
			res.close();
			st.close();
			conn.close();
			return pazienti;
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}

	public List<Arrivo> getAllArrivals(List<Paziente> pazienti) {
		final String sql = "SELECT * FROM arrivals";
		List<Arrivo> arrivi = new ArrayList<Arrivo>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				LocalDateTime id = res.getTimestamp("timestamp").toLocalDateTime();
				Paziente p = pazienti.get(pazienti.indexOf(new Paziente(res.getInt("patient"))));
				String triage = res.getString("triage");
				arrivi.add(new Arrivo(id, p, triage));
			}
			res.close();
			st.close();
			conn.close();
			return arrivi;
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}

	// TODO
}
