package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Return Button when clicked, returns back to the FinalProjectView Scene
 * @author CS219-user
 *
 */
public class ReturnButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Parent setupViewParent = null;
		
		try {
			setupViewParent = FXMLLoader.load(getClass().getResource("FinalProjectView.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene setupViewScene = new Scene(setupViewParent);
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(setupViewScene);
		window.show();
	}

}
