package application.controle;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import application.Appli;
import application.SGBD.BDD_utilisation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Accueil_Controller {
	@FXML
	private Button se_connecter,jouer_sans_co;
	@FXML
	private TextField pseudo,Mot_de_passe;
	@FXML
	private Hyperlink Mdp_oubli�,lien_inscription;
	@FXML
	private Label labelEtat;
	@FXML
	private Text titre;
	@FXML
	private  Button btn_quitter;
	
	public static Pane mainLayout;
	public static Stage primaryStage=new Stage(),stage_inscription;
	private static Stage stage=new Stage();
	
	protected Scene scene;
	private String nom_joueur;
	private String mdp_joueur;
	
	public String getnom_joueur() {
		return nom_joueur;
	}
	
	@FXML 
	private void verif_co_bdd() throws SQLException, IOException { //M�thode qui fonctionne
		String nom_joueur,mdp_joueur;
		BDD_utilisation.load_database();
		String requeteSQL="SELECT j.nom_joueur,j.mdp_joueur FROM joueur AS j WHERE (j.nom_joueur=? AND j.mdp_joueur=?)";
		PreparedStatement pstmt = BDD_utilisation.getConn().prepareStatement(requeteSQL);
		pstmt.setString(1, this.pseudo.getText());
		pstmt.setString(2, this.Mot_de_passe.getText());
		ResultSet resultat = pstmt.executeQuery();
		if (!resultat.next()) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Erreur d'authentification");
			alert.setContentText("Veuillez recommencez !");
			alert.showAndWait();
		}else {
			nom_joueur=resultat.getString(1);
			mdp_joueur=resultat.getString(2);
			this.nom_joueur=nom_joueur;
			this.setMdp_joueur(mdp_joueur);
			this.titre.setText("Bienvenue sur Miesto "+this.getnom_joueur());
			Alert alert=new Alert(AlertType.CONFIRMATION, "Vous �tes connect�(e), voulez-vous allez dans le menu du jeu ?",ButtonType.YES, ButtonType.NO);
			this.labelEtat.setText("Connect�(e)");
			alert.setHeaderText("Connect�(e)");
			alert.showAndWait();
			stage.initStyle(StageStyle.UNDECORATED);
			if (alert.getResult()==ButtonType.YES) {
				this.se_connecter.setDisable(true);
				this.jouer_sans_co.setDisable(true);
				ouvir_menu_jeu();
					
			}else {
				this.se_connecter.setDisable(true);
				this.jouer_sans_co.setDisable(true);
				JFXButton btn_jouer=new JFXButton("Jouer");
				btn_jouer.setLayoutX(14); btn_jouer.setLayoutY(360); btn_jouer.setPrefWidth(177); btn_jouer.setPrefHeight(31);
				btn_jouer.setId("btn_jouer");
				final URL cssURL = getClass().getResource("../view/style.css"); 
				btn_jouer.getStylesheets().add(cssURL.toExternalForm());
				btn_jouer.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try {
							ouvir_menu_jeu();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				btn_jouer.setDisable(false);
				primaryStage.show();
				
			}
		}
		
		
	}
	
	@FXML //fx:id jouer_sans_co. 
	/*M�thode qui servira pour le bouton 
	 * qui a pour fx:id se_connecter
	 * sous r�serve d'avoir v�rifier dans la base de donn�es que
	 * le login et le mot de passe sont corrects.    stage.initStyle(StageStyle.UNDECORATED);
	 * */
	private void ouvir_menu_jeu() throws IOException {
		
//		stage.setTitle("Menu - Miesto");
//		FXMLLoader  loader=new FXMLLoader();
//		loader.setLocation(Appli.class.getResource("view/menu_jeu_PJS4.fxml"));
//		mainLayout=loader.load();
//		scene_fen�tre_normale();
//		primaryStage.close();
//		Menu_jeu_Controller.stage_menu_jeu=stage;
		
		
		String cmd="src\\application\\JeuPJS4_Lebon\\JeuPJS4.exe";
		try {
			Runtime rt=Runtime.getRuntime();
			Process y=rt.exec(cmd);
			y.waitFor();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	@FXML //fx:id lien_inscription
	private void ouvrir_inscription(ActionEvent e) throws IOException {
		stage.setTitle("Inscription - Miesto");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Appli.class.getResource("view/inscription.fxml"));
		mainLayout=loader.load();
		scene_fen�tre_normale();
		primaryStage.close();
		stage_inscription=stage;
		
	}
	@FXML //fx:id Mdp_oubli�
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
		Alert alert=new Alert(AlertType.CONFIRMATION,"�tes-vous s�r de vouloir quittez l'application ?",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult()==ButtonType.YES) {
			primaryStage.close();
		}else {
			primaryStage.show();
		}
		
	}
	
	public static void scene_fen�tre_normale() {
		Scene scene=new Scene(mainLayout,645,450);
		stage.setScene(scene);
		stage.setMaxHeight(scene.getHeight());
		stage.setMaxWidth(scene.getWidth());
		stage.setMinHeight(scene.getHeight());
		stage.setMinWidth(scene.getWidth());
		stage.show();
	}

	public String getMdp_joueur() {
		return mdp_joueur;
	}

	public void setMdp_joueur(String mdp_joueur) {
		this.mdp_joueur = mdp_joueur;
	}
	
	
}
