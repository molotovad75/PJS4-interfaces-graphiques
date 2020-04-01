package application.controle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Menu_jeu_Controller {
	@FXML
	private Button retour_index;
	@FXML
	private Pane stage_menu_jeu;
	@FXML
	private Label mode_jeu_label;
	
	
	
	@FXML
	private void retour_acceuil() throws Exception {
		Accueil_Controller.stage_menu_jeu.close();
		Accueil_Controller.primaryStage.show();
	}

	
	public void messageBienvenue(String message) {
		mode_jeu_label.setText(message);
	}
	public Label getMode_jeu_label() {
		return mode_jeu_label;
	}


	
	
}
