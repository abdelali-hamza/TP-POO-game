import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

	@FXML
	TextField nameTextField;
    @FXML
    Label myLabel;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
    private Jeu game = new Jeu();
    
	
	public void login(ActionEvent event) throws IOException {
		String username = nameTextField.getText();
        Joueur ourUser=game.Login(username);
        if ( ourUser!= null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
            root = loader.load();
            Scene2Controller scene2Controller = loader.getController();
            scene2Controller.displayInfo(ourUser,game);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            myLabel.setText("User account doesnt exist");
        }
	}
    public void Signin(ActionEvent event) throws IOException {
        String username = nameTextField.getText();
        Joueur OurUser=game.Signin(username);
        if (OurUser!=null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
            root = loader.load();	
            Scene2Controller scene2Controller = loader.getController();
            scene2Controller.displayInfo(OurUser,game);	
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } else {
            myLabel.setText("User account  exists");   
        }

    }
}