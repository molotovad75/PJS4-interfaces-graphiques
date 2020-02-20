package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Appli extends Application {
	protected Pane mainLayout;
	protected Stage primaryStage;
	
	@FXML
	private Button se_connecter,jouer_sans_co;
	@FXML
	private TextField pseudo,Mot_de_passe;
	@FXML
	private Hyperlink Mdp_oubli�,lien_inscription;

	protected Scene scene;
	
	@FXML //
	private void ouvir_menu_jeu(ActionEvent e) throws IOException {
		Stage stage=new Stage();
		stage.setTitle("Menu - Miesto");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Appli.class.getResource("view/menu_jeu_PJS4.fxml"));
		loader.setController(new Menu_jeu_Controller());
		this.mainLayout=loader.load();
		Scene scene=new Scene(this.mainLayout,645,450);
		stage.setScene(scene);
		stage.setMaxHeight(scene.getHeight());
		stage.setMaxWidth(scene.getWidth());
		stage.setMinHeight(scene.getHeight());
		stage.setMinWidth(scene.getWidth());
		stage.show();
		
		this.primaryStage.close();
	}
	
	@FXML //
	private void verif_co_bdd(ActionEvent e) {
		
	}
	
	@FXML //
	private void entree_souris_bouton() {
		this.se_connecter.setTextFill(Color.DARKORANGE);
		
	}
	
	@FXML 
	/*pour le bouton se connecter et jouer sans se connecter 
	fx:id se_connecter et jouer_sans_co*/ 
	private void sortie_souris_bouton() {
		this.se_connecter.setTextFill(Color.BLACK);
		
	}
	
	@FXML
	private void entree_souris_bouton_jsc() {
		this.jouer_sans_co.setTextFill(Color.DARKORANGE);
	}
	
	@FXML
	private void sortie_souris_bouton_jsc() {
		this.jouer_sans_co.setTextFill(Color.BLACK);
	}
	
	@FXML //fx:id lien_inscription
	private void ouvrir_inscription(ActionEvent e) {
		
	}
	@FXML //
	private void ouvrir_form_mdp_oubli(ActionEvent e) {
		
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Miesto - connexion");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Appli.class.getResource("view/index.fxml"));
		loader.setController(this);
		this.mainLayout=loader.load();
		Scene scene=new Scene(this.mainLayout,645,450);
		primaryStage.setScene(scene);
		primaryStage.setMaxHeight(scene.getHeight());
		primaryStage.setMaxWidth(scene.getWidth());
		primaryStage.setMinHeight(scene.getHeight());
		primaryStage.setMinWidth(scene.getWidth());
		this.scene=scene;
		primaryStage.show();
		

	}
	
	public static void main(String[] args) {
		Appli.launch(Appli.class,args);
	}
	
		
}