package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Appli extends Application {

	//NE PAS TOUCHER AU METHODES SUIVANTES!!
	public static void main(String[] args) {
		launch(args);
	}
	//M�thode pour d�marrer l'application
		@Override
		public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("Connexion - Miesto");
			FXMLLoader  loader=new FXMLLoader();
			loader.setLocation(Appli.class.getResource("view/index.fxml"));
			application.controle.Accueil_Controller.mainLayout=loader.load();
			Scene scene=new Scene(application.controle.Accueil_Controller.mainLayout,645,450);
			primaryStage.setScene(scene);
			primaryStage.setMaxHeight(scene.getHeight());
			primaryStage.setMaxWidth(scene.getWidth());
			primaryStage.setMinHeight(scene.getHeight());
			primaryStage.setMinWidth(scene.getWidth());
			//application.controle.Accueil_Controller.mettre_image_btn_quitter();
			primaryStage.initStyle(StageStyle.UNDECORATED);
			application.controle.Accueil_Controller.primaryStage=primaryStage;
			primaryStage.show(); //On affiche la fen�tre.
		}
}
