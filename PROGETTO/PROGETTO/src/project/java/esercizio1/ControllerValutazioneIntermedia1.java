package project.java.esercizio1;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextArea;
    import javafx.scene.input.MouseEvent;
import project.java.general.SceneController;
    
    
    public class ControllerValutazioneIntermedia1 {
    
        @FXML
        private Button goToDashboard;
    
        @FXML
        private Button goToExercise1;
    
        @FXML
        private Label lblLivello;
    
        @FXML
        private Label lblRisposteCorrette;
    
        @FXML
        private Label lblRisposteSbagliate;
    
        @FXML
        private TextArea testoDomanda1;
    
        @FXML
        private TextArea testoDomanda2;
    
        @FXML
        private TextArea testoDomanda3;
    
        @FXML
        void switchToDashboard(MouseEvent event) {
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
            String location = "/project/resources/esercizio1/esercizio1.fxml";
            try{

                FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
                Parent esercizio1Root = loader.load();

                SceneController.switchScene((Node) event.getSource(), esercizio1Root);
    
            }catch(IOException | RuntimeException e){
                SceneController.showControllerError(e, location);
            }
            
        }
    
    }

