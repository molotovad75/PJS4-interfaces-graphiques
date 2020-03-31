package application.controle;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Appli;
import application.SGBD.BDD_utilisation;
import application.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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
	@FXML
	private Text titre;
	@FXML
	private  Button btn_quitter;
	
	public static Pane mainLayout;
	public static Stage primaryStage=new Stage(),stage_menu_jeu,stage_inscription,stage_mdp_oublié;
	private static Stage stage=new Stage();
	
	protected Scene scene;

	
	@FXML 
	private void verif_co_bdd() throws SQLException { //Méthode qui fonctionne
		BDD_utilisation.load_database();
		String requeteSQL="SELECT j.nom_joueur,j.mdp_joueur FROM joueur AS j WHERE (j.nom_joueur=? AND j.mdp_joueur=?)";
		PreparedStatement pstmt = BDD_utilisation.getConn().prepareStatement(requeteSQL);
		pstmt.setString(1, this.pseudo.getText());
		pstmt.setString(2, this.Mot_de_passe.getText());
		ResultSet resultat = pstmt.executeQuery();
		if (!resultat.next()) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Erreur de connexion");
			alert.setContentText("Veuillez recommencez !");
			alert.showAndWait();
		}else {
			while (resultat.next()) {
				String nom_joueur=resultat.getString(1);
				String mdp_joueur=resultat.getString(2);
				this.labelEtat.setText("Connecté");
				this.titre.setText("Bienvenue sur Miesto "+nom_joueur);
			}
			Alert alert=new Alert(AlertType.CONFIRMATION, "Vous êtes connecté(e), voulez-vous allez dans le menu du jeu ?",ButtonType.YES, ButtonType.NO);
			alert.setHeaderText("Connecté(e)");
			alert.showAndWait();
			
		}
		
		
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
		 try {
			Desktop.getDesktop().browse(new URL("https://osu.ppy.sh/home").toURI()); //Il faudra changer l'URL pour le site de notre projet.
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	     
	}
	
	@FXML
	private void ouvrir_score(ActionEvent e) {
		try {
			Desktop.getDesktop().browse(new URL("https://www.amazon.fr/Apple-Ordinateur-bureau-quadricoeur-graphique/dp/B004ZBDJ6M?tag=coa_fr-21").toURI()); //Il faudra changer l'URL pour le site de notre projet.
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	@FXML
	private void quittez(ActionEvent e) {
		Alert alert=new Alert(AlertType.CONFIRMATION,"Êtes-vous sûr de vouloir quittez l'application ?",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult()==ButtonType.YES) {
			primaryStage.close();
		}else {
			primaryStage.show();
		}
		
	}
	
	public void mettre_image_btn_quitter() {
		  Image playI=new Image(Accueil_Controller.class.getResourceAsStream("../../images/che_guevarra.png"));
		
		  btn_quitter.setGraphic(new ImageView(playI));
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
