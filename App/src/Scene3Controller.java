import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AmbientLight;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Scene3Controller {
    @FXML
    GridPane gridImages;

    @FXML
    Text answer;
    @FXML
    AnchorPane anch;
    @FXML
    Text goodorbad;
    @FXML
    Text find;

    @FXML
    void chose(ActionEvent event){
        System.out.println("hello");

     }


    public void   genqst( Partie partie){
        File folder = new File("/Users/Abdelali/Desktop/App-Poo-Last/App/src/imagesQuestions");
        File files[] = folder.listFiles(); 
        System.out.println("files length" +files.length);
        int iterateur = 0;
        int i  =  (int) (Math.random() *4);
        ArrayList<Integer> tab = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Collections.shuffle(tab);
        System.out.println(tab);
        
        for ( Node node : gridImages.getChildren()) {
            
            
            int j  =  tab.get(iterateur);
            Image hh=new Image("./imagesQuestions/"+files[j].getName());
            ((ImageView)node).setImage(hh);
            System.out.println("sheep loaded");
            ((ImageView)node).setId(files[j].getName().replace(".jpg", ""));
            if( iterateur == i){
                
                System.out.println(files[j].getName().replace(".jpg", ""));
                answer.setText(files[j].getName().replace(".jpg", ""));
            }
            ((ImageView)node).setOnMouseClicked(event ->{
                if( answer.getText().equals(  ((ImageView)node).getId())){
                    System.out.println("good answer");
                    anch.setStyle("-fx-background-color: rgb(102,255,153,0.5)");
                    goodorbad.setText("Good answer !  congrats buddy");
                    answer.setText("");
                    gridImages.setVisible(false);
                    find.setText("");
                    PauseTransition pt = new PauseTransition(Duration.seconds(2));
                    pt.setOnFinished(ee -> {
                        Stage stage = (Stage)gridImages.getScene().getWindow();
                        stage.close();
                    });
                    pt.play();
                    partie.setPosition(partie.getPosition()+3);
                    partie.setScore(partie.getScore()+10);
                   
                }
                else{
                    System.out.println("good answer");
                    anch.setStyle("-fx-background-color: rgb(255,0,0,0.5)");
                    goodorbad.setText("Wrong answer buddy !");
                    answer.setText("");
                    gridImages.setVisible(false);
                    find.setText("");
                    PauseTransition pt = new PauseTransition(Duration.seconds(2));
                    pt.setOnFinished(ee -> {
                        Stage stage = (Stage)gridImages.getScene().getWindow();
                        stage.close();
                    });
                    pt.play();
                    partie.setPosition(partie.getPosition()+3);
                }
               
            });
            iterateur++;
        }
        
    }
}