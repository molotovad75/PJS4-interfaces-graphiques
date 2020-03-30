package application.controle;

import application.SGBD.DAO;
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
		String sql = "INSERT INTO joueur(id_joueur,nom_utilisateur, nom_joueur, mail_joueur, code_confirmation, date_confirmation, mdp_joueur, temps_jeu) " + 
                "VALUES('null', 'username', 'pseudo', 'mail', 'NOW(), 'mdp1', '')";
		DAO.insérer_data(sql);
		
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
