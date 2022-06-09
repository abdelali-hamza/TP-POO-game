import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class App extends Application {
	
	@Override
	public void start(Stage stage) {
		
		try {
			System.out.println("test avant");
			Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			System.out.println("test apres");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			//stage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	public static void main(String[] args) {
		launch(args);
	}
}