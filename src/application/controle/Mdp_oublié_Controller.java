package application.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Mdp_oubli�_Controller {
	
	@FXML
	private Button retour_index;

	@FXML
	private void retour_acceuil() throws Exception {
		Accueil_Controller.stage_mdp_oubli�.close();
		Accueil_Controller.primaryStage.show();
	}	
}
