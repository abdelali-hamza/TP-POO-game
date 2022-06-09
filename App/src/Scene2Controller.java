import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class Scene2Controller {

	/*@FXML
    Label nameLabel;
	*/
    @FXML
    Label info1;
    @FXML
    Label info2;
    @FXML
    Label info3;
    @FXML
    Label info4;
    @FXML
    Label info5;
    @FXML
    GridPane grid;

    @FXML
    ImageView dice;
    @FXML
    ImageView dice31;
    @FXML
    ImageView dice2;
    @FXML
    ImageView dice3;
    @FXML
    Button roll;
    @FXML 
    Button quit;
    Parent root;
    Stage stage;
    Scene scene;
    FXMLLoader loader;
    @FXML 
    Button save;
    @FXML
    Button New;
    @FXML
    Button restart;
    @FXML 
    Text winorlose;
    @FXML
    AnchorPane board;
    @FXML
    Button restart1;

	public void displayInfo(Joueur user,Jeu game) {
        save.setOnMouseClicked(e->{
            board.setStyle("");
            winorlose.setText("");
            grid.setVisible(true);
            System.out.println("entered saving process");
            game.Joueurs.put(user.getNom(), user); 
            game.SaveData();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./Scene1.fxml"));	
            try {
                root = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            game.GetData();;
            Scene1Controller scene1Controller = loader.getController();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
        restart1.setOnMouseClicked(e->{
            System.exit(0);
        });;
        New.setOnMouseClicked(e->{
            board.setStyle("");
            winorlose.setText("");
            grid.setVisible(true);
            user.PartieDuJoeur= new Partie();
            LoadPlateau(user);
            user.PartieDuJoeur.setPosition(0);
            user.PartieDuJoeur.setScore(0);
            info2.setText("Meilleur Score : "+user.getScore());
            info3.setText("Score actuel : "+user.PartieDuJoeur.getScore());
            info4.setText("Position actuelle : "+user.PartieDuJoeur.getPosition());
            for (Node node2 : grid.getChildren()) {
                if (node2 != recherche(grid, user.PartieDuJoeur.getPosition())) {
                    ((Button) node2).setGraphic(null);
                    ((Button) node2).setBorder(null);

                }
            }
            Dessiner_perso(recherche(grid, user.PartieDuJoeur.getPosition()));
            this.deroulement_jeu(user);
        });
        restart.setOnMouseClicked(e->{
            board.setStyle("");
            winorlose.setText("");
            grid.setVisible(true);
            user.PartieDuJoeur.setPosition(0);
            user.PartieDuJoeur.setScore(0);
            info2.setText("Meilleur Score : "+user.getScore());
            info3.setText("Score actuel : "+user.PartieDuJoeur.getScore());
            info4.setText("Position actuelle : "+user.PartieDuJoeur.getPosition());
            for (Node node2 : grid.getChildren()) {
                if (node2 != recherche(grid, user.PartieDuJoeur.getPosition())) {
                    ((Button) node2).setGraphic(null);
                    ((Button) node2).setBorder(null);

                }
            }
            Dessiner_perso(recherche(grid, user.PartieDuJoeur.getPosition()));
            this.deroulement_jeu(user);

        });
        info1.setText("User Name : "+user.getNom());
        info2.setText("Meilleur Score : "+user.getScore());
        info3.setText("Score actuel : "+user.PartieDuJoeur.getScore());
        info4.setText("Position actuelle : "+user.PartieDuJoeur.getPosition());
        info5.setText("Game score : "+game.meilleur_score_global+"\n"+"");
        user.PartieDuJoeur.afficherPlateau();
        LoadPlateau(user);
        try {
            this.deroulement_jeu(user);
        } catch (Exception e) {

        }

	}
    public void hamza(){
        System.out.println("hola");;
    }
    public void action(ActionEvent e){
        System.out.println("test worked");
    }
    public void LoadPlateau(Joueur user){
        for ( Node node:grid.getChildren()) {
            
            Button mybutton=(Button)(node);
            int index = Integer.parseInt(mybutton.getText());
            String style = mybutton.getStyle() ;
            style +=";-fx-background-color: "+user.PartieDuJoeur.plateau[index-1].getColor();
            mybutton.setStyle(style);
        }
    }
    public Button recherche(GridPane ourGrid,int index){
        index+=1;
        Button buttontoreturn = new Button();
        buttontoreturn=null;

        for (Node node : ourGrid.getChildren()) {
            Button mybutton=(Button)(node);
            if (index == Integer.parseInt(mybutton.getText())) buttontoreturn=mybutton;
            
        }
        return buttontoreturn;
    }

    public void deroulement_jeu(Joueur joueur) {
        Button btn = recherche(grid,joueur.PartieDuJoeur.getPosition());
        btn.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        for (Node node : grid.getChildren()) {
            node.setOnMouseClicked(event -> {
                
                String sami =joueur.PartieDuJoeur.plateau[Integer.parseInt(((Button) node).getText())-1].getColor();
                if ( Integer.parseInt(((Button) node).getText()) ==joueur.PartieDuJoeur.getPosition()+1 || sami.equals("Pink")  || sami.equals("Green")|| sami.equals("Red")|| sami.equals("blue") || sami.equals("orange")|| sami.equals("Black")) {
                    joueur.PartieDuJoeur.setPosition(Integer.parseInt(((Button) node).getText())-1);
                    joueur.PartieDuJoeur.plateau[joueur.PartieDuJoeur.getPosition()].action(joueur,0); 
                    
                    dice31.setVisible(false);
                    dice3.setVisible(false);
                    Dessiner_perso(((Button) node));
                    info3.setText("Score actuel : "+joueur.PartieDuJoeur.getScore());
                    info4.setText("Position actuelle : "+joueur.PartieDuJoeur.getPosition());
                    String color=joueur.PartieDuJoeur.plateau[joueur.PartieDuJoeur.getPosition()].getColor();
                    if ( color.equals("Grey") ||color.equals("Yellow")) {
                        
                        roll.setOnAction((e)->{
                            int chiffre1= 1+(int)(Math.random()*6);
                            int chiffre2= 1+(int)(Math.random()*6);
                            String link1="assets/Dice"+ Integer.toString(chiffre1) +".png";
                            String link2="assets/Dice"+Integer.toString(chiffre2)+".png";
                            Image myimg =new Image("assets/dice_rolling.gif");
                            Image myimg1 =new Image(link1);
                            Image myimg2 =new Image(link2);
                            dice.setVisible(true);
                            dice2.setVisible(true);
                            dice31.setVisible(false);
                            dice3.setVisible(false);
                            dice.setImage(myimg);
                            dice2.setImage(myimg);
                            PauseTransition pt = new PauseTransition(Duration.seconds(0.5));
                            pt.setOnFinished(ee -> {
                                dice.setVisible(false);
                                dice2.setVisible(false);
                                dice31.setVisible(true);
                                dice3.setVisible(true);
                                dice31.setImage(myimg1);
                                dice3.setImage(myimg2);
            
                            });
                            pt.play();
                            joueur.PartieDuJoeur.plateau[joueur.PartieDuJoeur.getPosition()].action(joueur,chiffre1+chiffre2);
                            roll.setOnAction(ee->{});

                        });
                        
                    } 
                    else {
                        roll.setOnAction(eee->{});                        
                    }
                     btn.setOnMouseClicked(null);
                    for (Node node2 : grid.getChildren()) {
                        if (node2 != node) {
                            ((Button) node2).setGraphic(null);
                            ((Button) node2).setBorder(null);

                        }
                    }
                    if ( joueur.PartieDuJoeur.getPosition() == 99) {
                        grid.setVisible(false);
                        if (joueur.PartieDuJoeur.getScore() > joueur.getScore()) {
                            joueur.setScore(joueur.PartieDuJoeur.getScore());
                            board.setStyle("-fx-background-color: rgb(102,255,153,0.5)");
                            if(joueur.PartieDuJoeur.getScore()>Jeu.meilleur_score_global)winorlose.setText("Congratulations buddy ! you beated the game high score");
                            else winorlose.setText("Congratulations buddy ! you beated your personal high score");
                        }
                        else if (joueur.PartieDuJoeur.getScore()>Jeu.meilleur_score_global){
                            board.setStyle("-fx-background-color: rgb(102,255,153,0.5)");
                            winorlose.setText("Congratulations buddy ! you beated the game high score");
                        }
                        else {
                            board.setStyle("-fx-background-color: rgb(255,0,0,0.4)");
                            winorlose.setText("You didnt improve from you last time , try to play more !");

                        }
                        
                        
                        
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Be carefull");
                    alert.setHeaderText("Wrong move , think again");
                    alert.setContentText(" - If you didnt roll your dice , roll it \n - Else pick the right destination by adding the dice score to your position ");
                    alert.showAndWait();
                }
                Button btnNext = recherche(grid,joueur.PartieDuJoeur.getPosition());
                btnNext.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            });
        }
    }
    

    public void Dessiner_perso(Button button) {
        Image image = new Image(getClass().getResource("./assets/pawn.png").toExternalForm());
        ImageView icon = new ImageView(image);
        icon.setRotate(-90);
        button.setGraphic(icon);
    }
}


