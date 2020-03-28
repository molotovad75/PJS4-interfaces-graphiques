package application.controle;

import java.sql.SQLException;

import application.SGBD.BDD_utilisation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Inscription_Controller {
	
	@FXML
	private Button retour_acceuil;
	@FXML
	private Button valider;
	//Text field du formulaire.
	@FXML
	private TextField username;
	@FXML
	private TextField pseudo;
	@FXML
	private TextField mail;
	@FXML
	private TextField mdp1;
	@FXML
	private TextField mdp2;	
	
	
	
	@FXML
	private void retour_acceuil() throws Exception {
		Accueil_Controller.stage_inscription.close();
		Accueil_Controller.primaryStage.show();
	}
	
	@FXML
	private void inscription() {
		String requeteSQL="INSERT INTO joueur(nom_utilisateur,nom_joueur,mail_joueur,code_confirmation,date_confirmation,mdp_joueur,temps_jeu) "
				+ "VALUES('"+username+"','"+pseudo+"','"+mail+"','',NOW(),'"+mdp1+"','');";
		try {
			BDD_utilisation.connect_other_query(requeteSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public TextField getUsername() {
		return username;
	}

	public TextField getPseudo() {
		return pseudo;
	}

	public TextField getMail() {
		return mail;
	}

	public TextField getMdp1() {
		return mdp1;
	}

	public TextField getMdp2() {
		return mdp2;
	}

}
