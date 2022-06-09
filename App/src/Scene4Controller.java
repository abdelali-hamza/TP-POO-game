import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javax.print.attribute.TextSyntax;

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
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextFormatter.Change;
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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Scene4Controller {
    @FXML
    Text reponse;
    @FXML
    HBox hbox;
    @FXML
    Button btnconfirm;
    @FXML
    AnchorPane anch;
    @FXML
    Text goodorbad;
    @FXML 
    Text find;

    public void   genqst( Partie partie){
        ArrayList<QuestionDefinition> tab= new ArrayList<>();
        tab.add(new QuestionDefinition("A building for human habitation", "house"));
        tab.add(new QuestionDefinition("A place where we cook ", "kitchen"));
        tab.add(new QuestionDefinition("A four-wheeled road vehicle that is powered by an engine", "car"));
        tab.add(new QuestionDefinition("A small timepiece worn typically on a strap on one's wrist", "watch"));
        tab.add(new QuestionDefinition("A device for giving light", "lamp"));
        tab.add(new QuestionDefinition("Tool used for opening doors", "key"));
        tab.add(new QuestionDefinition("An instrument composed of a blade fixed into a handle", "knife"));
        tab.add(new QuestionDefinition("A weapen used to shoot from long distances", "sniper"));
        int i = (int)(Math.random()*8);
        System.out.println(tab.get(i).getDefinition());
        System.out.println(tab.get(i).getReponse());
        reponse.setText(tab.get(i).getDefinition()); 
        for (int j = 0; j <tab.get(i).getReponse().length(); j++) {
            TextField hh = new TextField();
            hh.setTextFormatter(new TextFormatter<String>((Change change) -> {
                String newText = change.getControlNewText();
                if (newText.length() > 1) {
                    return null;
                } else {
                    return change;
                }
            }));
            hh.setFont(Font.font("Arial", FontWeight.BOLD, 25));
            hh.setPrefWidth(60);
            hh.setPrefHeight(60);
            hbox.getChildren().add(hh);
        }
        btnconfirm.setOnAction(e->{
            System.out.println("entered event");
            String str="";
            for (Node node:hbox.getChildren()) {
                str+=((TextField)node).getText();
            }
            System.out.println(str);
            if ( str.equals(tab.get(i).reponse)){
                System.out.println("good answer");
                anch.setStyle("-fx-background-color: rgb(102,255,153,0.5)");
                goodorbad.setText("Good answer !  congrats buddy");
                find.setText("");
                hbox.setVisible(false);
                reponse.setText("");
                btnconfirm.setVisible(false);
                PauseTransition pt = new PauseTransition(Duration.seconds(2));
                pt.setOnFinished(ee -> {
                    Stage stage = (Stage)hbox.getScene().getWindow();
                    stage.close();
                });
                pt.play();
                partie.setScore(partie.getScore()+10);
                partie.setPosition(partie.getPosition()+3);

                
            }
            else{
                System.out.println("bad answer");
                anch.setStyle("-fx-background-color: rgb(255,0,0,0.5)");
                goodorbad.setText("       Wrong answer buddy ! ");
                find.setText("");
                hbox.setVisible(false);
                reponse.setText("");
                btnconfirm.setVisible(false);
                PauseTransition pt = new PauseTransition(Duration.seconds(2));
                pt.setOnFinished(ee -> {
                    Stage stage = (Stage)hbox.getScene().getWindow();
                    stage.close();
                });
                pt.play();
                partie.setPosition(partie.getPosition()+3);

            }

        });


    }
}