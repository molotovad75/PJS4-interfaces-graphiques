package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu_jeu_Controller extends Appli{
	protected Pane mainLayout;
	protected Stage stage;
	@FXML
	private Button retour_index;
	@FXML
	private void retour_acceuil(ActionEvent e) throws IOException {
		Stage primaryStage=new Stage();
//		this.primaryStage=primaryStage;
//		this.mainLayout=null;
		//this.primaryStage.setTitle("Miesto - connexion");
		FXMLLoader  loader=new FXMLLoader();
		loader.setLocation(Menu_jeu_Controller.class.getResource("view/index.fxml"));
		//loader.setController(new Appli());
		loader.setController("Appli.java");
		Scene scene=new Scene(loader.load(),645,450);
		
		primaryStage.setScene(scene);
		primaryStage.setMaxHeight(scene.getHeight());
		primaryStage.setMaxWidth(scene.getWidth());
		primaryStage.setMinHeight(scene.getHeight());
		primaryStage.setMinWidth(scene.getWidth());
		primaryStage.show();
		stage.close();
	}
}
