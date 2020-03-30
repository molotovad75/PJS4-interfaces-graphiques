package application.controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.SGBD.BDD_utilisation;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
	private void inscription() { //L'inscription fonctionne
		String requeteSQL="INSERT INTO joueur(nom_utilisateur,nom_joueur,mail_joueur,code_confirmation,date_confirmation,mdp_joueur,temps_jeu) "
				+ "VALUES(?,?,?,'123',CURDATE(),?,TIMESTAMP(\"2018-09-15\"))";
		try {
			BDD_utilisation.load_database();
			PreparedStatement preparedStatement=BDD_utilisation.getConn().prepareStatement(requeteSQL);
			preparedStatement.setString(1, username.getText());
			preparedStatement.setString(2, pseudo.getText());
			preparedStatement.setString(3, mail.getText());
			preparedStatement.setString(4, mdp1.getText());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("");
		alert.setContentText("Votre inscription a bien été prise en compte !");
		alert.showAndWait();
		this.username.setText("");
		this.pseudo.setText("");
		this.mail.setText("");
		this.mdp1.setText("");
		this.mdp2.setText("");
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
