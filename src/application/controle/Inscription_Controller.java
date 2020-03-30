package application.controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

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
	
	
	public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
	           "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
	           "\\@" +
	           "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
	           "(" +
	           "\\." +
	           "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
	           ")+"
	);
	
	public static boolean isValiEmail(String email){
	    return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
	}
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
			if (mdp1.getText().equals(mdp2.getText())==true && isValiEmail(this.mail.getText())==true ) {
				preparedStatement.executeUpdate();
				Alert alert_principale=new Alert(AlertType.INFORMATION);
				alert_principale.setTitle("Information");
				alert_principale.setHeaderText("");
				alert_principale.setContentText("Votre inscription a bien été prise en compte !");
				alert_principale.showAndWait();
				this.username.setText("");
				this.pseudo.setText("");
				this.mail.setText("");
				this.mdp1.setText("");
				this.mdp2.setText("");
			}else if(mdp1.getText().equals(mdp2.getText())==false) {
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("");
				alert.setContentText("Les 2 mots de passe ne coincident pas");
				alert.showAndWait();
				this.mdp1.setText("");
				this.mdp2.setText("");
				
			}else if (isValiEmail(this.mail.getText())==false) {
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("");
				alert.setContentText("L'adresse électronique est invalide");
				alert.showAndWait();
				this.mail.setText("");
			}
			
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
