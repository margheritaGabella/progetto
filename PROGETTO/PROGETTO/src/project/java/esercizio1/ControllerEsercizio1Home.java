package project.java.esercizio1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import project.java.general.SceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import java.io.IOException;

public class ControllerEsercizio1Home
 {

    @FXML
    private ImageView goToDashboard;

    @FXML
    void switchToDashboardScene(MouseEvent event) {
            String location = "/project/resources/dashboard/dashboard.fxml";  
           // SceneController.loadFXML(event, "/project/resources/dashboard/dashboard.fxml");
    
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
                Parent dashboardRoot = loader.load();
        
                //setWelcomeText();
                SceneController.switchScene((Node) event.getSource(), dashboardRoot);
    
            }catch(IOException | RuntimeException e){
                SceneController.showControllerError(e, location);
            }
    }
    

    @FXML
    void switchToExercise1(MouseEvent event) {
            SceneController.loadFXML(event, "/project/resources/esercizio1/esercizio1.fxml");
    }


}
