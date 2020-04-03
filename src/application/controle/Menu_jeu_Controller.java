package application.controle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu_jeu_Controller {
	@FXML
	private Button retour_index;
//	@FXML
//	private Pane stage_menu_jeu;
	@FXML
	private Label mode_jeu_label;
	
	public static Stage stage_menu_jeu;
	
	@FXML
	private void retour_acceuil() throws Exception {
		stage_menu_jeu.close();
		Accueil_Controller.primaryStage.show();
	}

	
	public Label getMode_jeu_label() {
		return mode_jeu_label;
	}


	
	
}
