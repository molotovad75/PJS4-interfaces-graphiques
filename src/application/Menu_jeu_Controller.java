package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Menu_jeu_Controller extends Appli{
	protected Pane mainLayout;
	
	@FXML
	private Button retour_index;
	
	@FXML
	private void retour_acceuil() throws Exception {
		start(primaryStage);
		this.stage_menu_jeu.close();
	}
}
