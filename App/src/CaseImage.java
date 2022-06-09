import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CaseImage extends CaseQuestion {
    int Parcourue;
    
    //
    public CaseImage() {
        super("Pink");
        Parcourue=0;
    }
    @Override
    public void action(Joueur user,int a)  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));	
        try {
            Parent root;
            root = loader.load();
            Scene3Controller scene3Controller = loader.getController();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root,638,444));
            secondStage.initModality(Modality.APPLICATION_MODAL );
            secondStage.show();
            scene3Controller.genqst(user.PartieDuJoeur);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}