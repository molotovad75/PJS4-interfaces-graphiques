package application.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Inscription_Controller {
	
	@FXML
	private Button retour_acceuil;
	
	@FXML
	private void retour_acceuil() throws Exception {
		Accueil_Controller.stage_inscription.close();
		Accueil_Controller.primaryStage.show();
	}
	
	
}
