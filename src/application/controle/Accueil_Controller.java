package application.controle;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
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

	
	@FXML 
	private Joueur verif_co_bdd() throws SQLException {
		Statement statement = null;
        ResultSet resultat = null;
        Joueur joueur=null;
		String requeteSQL="SELECT j.nom_joueur,j.mdp_joueur FROM joueur AS j WHERE j.nom_joueur="+pseudo.getText()+" AND j.mdp_joueur="+Mot_de_passe.getText()+";";
		try {
			BDD_utilisation.load_database();
			statement=BDD_utilisation.getConn().createStatement();
			resultat=statement.executeQuery(requeteSQL);
			while (resultat.next()) {
				String nom_joueur=resultat.getString("j.nom_joueur");
				String mdp_joueur=resultat.getString("j.mdp_joueur");
				joueur=new Joueur();
				joueur.setNom_joueur(nom_joueur);
				joueur.setMdp_joueur(mdp_joueur);
				labelEtat.setText(joueur.toString());
			}
		} catch (SQLException e) {
			e.getMessage();
		}finally {
			// Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (BDD_utilisation.getConn() != null)
                	BDD_utilisation.getConn().close();
            } catch (SQLException ignore) {
            	ignore.getMessage();
            }
		}
		return joueur;
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
