package application.controle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Appli;
import application.SGBD.BDD_utilisation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Accueil_Controller {
	@FXML
	private Button se_connecter,jouer_sans_co;
	@FXML
	private TextField pseudo,Mot_de_passe;
	@FXML
	private Hyperlink Mdp_oublié,lien_inscription;
	@FXML
	private Label labelEtat;
	
	
	public static Pane mainLayout;
	public static Stage primaryStage=new Stage(),stage_menu_jeu,stage_inscription,stage_mdp_oublié;
	private static Stage stage=new Stage();
	
	protected Scene scene;
	


//	/*pour le bouton se connecter et jouer sans se connecter 
//	 * Pour que ça change de couleur.
//	fx:id se_connecter et jouer_sans_co*/ 
//	@FXML 
//	private void entree_souris_bouton() {
//		this.se_connecter.setTextFill(Color.DARKORANGE);	
//		
//	}
//	@FXML 
//	private void sortie_souris_bouton() {
//		this.se_connecter.setTextFill(Color.BLACK);	
//	}
//	@FXML
//	private void entree_souris_bouton_jsc() { //jouer sans se connecter
//		this.jouer_sans_co.setTextFill(Color.DARKORANGE);
//	}
//	@FXML
//	private void sortie_souris_bouton_jsc() { //jouer sans se connecter
//		this.jouer_sans_co.setTextFill(Color.BLACK);
//	}
	
	@FXML 
	private void verif_co_bdd() throws SQLException {
		String SQL="SELECT j.nom_utilisateur,j.mdp_joueur FROM joueur AS j WHERE j.nom_joueur=? AND j.mdp_joueur=?";
		
//		try {
//			stat=con.prepareStatement(SQL);
//			stat.setString(1, pseudo.getText().toString());
//			stat.setString(2, Mot_de_passe.getText().toString());
//			rs=stat.executeQuery();
//			if (rs.next()) {
//				labelEtat.setText("Connecté");
//			}else
//			{
//				labelEtat.setText("Non connecté");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.getMessage();
//		}
	}
	
	
	
	
	
	@FXML //fx:id jouer_sans_co. 
	/*Méthode qui servira pour le bouton 
	 * qui a pour fx:id se_connecter
	 * sous réserve d'avoir vérifier dans la base de données que
	 * le login et le mot de passe sont corrects.
	 * */
	private void ouvir_menu_jeu(ActionEvent e) throws IOException {
		
		stage.setTitle("Menu - Miesto");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Appli.class.getResource("view/menu_jeu_PJS4.fxml"));
		mainLayout=loader.load();
		scene_fenètre_normale();
		primaryStage.close();
		stage_menu_jeu=stage;
	}
	
	@FXML //fx:id lien_inscription
	private void ouvrir_inscription(ActionEvent e) throws IOException {
		stage.setTitle("Inscription - Miesto");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Appli.class.getResource("view/inscription.fxml"));
		mainLayout=loader.load();
		scene_fenètre_normale();
		primaryStage.close();
		stage_inscription=stage;
		
	}
	@FXML //fx:id Mdp_oublié
	private void ouvrir_form_mdp_oubli(ActionEvent e) throws IOException {
		stage.setTitle("Mot de passe oublié - Miesto");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Appli.class.getResource("view/formulaire_mdp_oublié.fxml"));
		mainLayout=loader.load();
		scene_fenètre_normale();
		primaryStage.close();
		stage_mdp_oublié=stage;
	}
	
	public static void scene_fenètre_normale() {
		Scene scene=new Scene(mainLayout,645,450);
		stage.setScene(scene);
		stage.setMaxHeight(scene.getHeight());
		stage.setMaxWidth(scene.getWidth());
		stage.setMinHeight(scene.getHeight());
		stage.setMinWidth(scene.getWidth());
		stage.show();
	}
	
	
}
