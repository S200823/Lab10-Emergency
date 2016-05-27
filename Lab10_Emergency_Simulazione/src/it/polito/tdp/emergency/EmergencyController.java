package it.polito.tdp.emergency;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.emergency.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmergencyController {

	Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtDottore;

	@FXML
	private TextField txtOreSfalsamento;

	@FXML
	private TextArea txtRisultato;

	@FXML
	private Button btnAggiungiDottore;

	@FXML
	private Button btnSimula;

	@FXML
	void doAggiungiDottore(ActionEvent event) {
		if (!txtDottore.getText().isEmpty() && !txtOreSfalsamento.getText().isEmpty()) {
			String nomeDottore = txtDottore.getText();
			try {
				int oreSfalsamento = Integer.parseInt(txtOreSfalsamento.getText());
				model.addDottore(nomeDottore, oreSfalsamento);
				txtRisultato.setText("Aggiunto!");
			} catch (NumberFormatException nfe) {
				txtRisultato.setText("Inserire numero e non testo.");
			}
		} else
			txtRisultato.setText("Compilare tutti i campi.");
	}

	@FXML
	void doSimula(ActionEvent event) {
		String statistiche = model.simula();
		txtRisultato.setText(statistiche);
	}

	@FXML
	void initialize() {
		assert txtDottore != null : "fx:id=\"textDottore\" was not injected: check your FXML file 'Emergency.fxml'.";
		assert txtOreSfalsamento != null : "fx:id=\"textOreSfalsamento\" was not injected: check your FXML file 'Emergency.fxml'.";
		assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Emergency.fxml'.";
		assert btnAggiungiDottore != null : "fx:id=\"btnAggiungiDottore\" was not injected: check your FXML file 'Emergency.fxml'.";
		assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Emergency.fxml'.";
	}
}
