package application;

import application.controle.Accueil_Controller;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Appli extends Application {

	//NE PAS TOUCHER AU METHODES SUIVANTES!!
	public static void main(String[] args) {
		launch(args);
	}
	//M�thode pour d�marrer l'application
		@Override
		public void start(Stage primaryStage) throws Exception {
			Accueil_Controller.primaryStage=primaryStage;
			primaryStage.setTitle("Connexion - Miesto");
			FXMLLoader  loader=new FXMLLoader();
			loader.setLocation(Appli.class.getResource("view/index.fxml"));
			loader.setController(Accueil_Controller.class);
			Accueil_Controller.mainLayout=loader.load();
			Scene scene=new Scene(Accueil_Controller.mainLayout,645,450);
			primaryStage.setScene(scene);
			primaryStage.setMaxHeight(scene.getHeight());
			primaryStage.setMaxWidth(scene.getWidth());
			primaryStage.setMinHeight(scene.getHeight());
			primaryStage.setMinWidth(scene.getWidth());
			primaryStage.show();
		}
		

		
}
