import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CaseDefinition extends CaseQuestion {
    int Parcourue;
    public CaseDefinition() {
        super("blue");
        Parcourue=0;
    }
    @Override
    public void action(Joueur user,int a) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
        try {
            Parent root;
            root = loader.load();
            Scene4Controller scene4Controller = loader.getController();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root,622,551));
            secondStage.initModality(Modality.APPLICATION_MODAL );
            secondStage.show();
            scene4Controller.genqst(user.PartieDuJoeur);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
