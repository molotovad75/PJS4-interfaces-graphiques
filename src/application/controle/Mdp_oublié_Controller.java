package application.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Mdp_oublié_Controller {
	
	@FXML
	private Button retour_index;

	@FXML
	private void retour_acceuil() throws Exception {
		Accueil_Controller.stage_mdp_oublié.close();
		Accueil_Controller.primaryStage.show();
	}	
}
