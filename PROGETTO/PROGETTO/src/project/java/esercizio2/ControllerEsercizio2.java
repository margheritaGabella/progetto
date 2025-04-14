package project.java.esercizio2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import project.java.dashboard.UserScraper;
import project.java.general.SceneController;
import java.io.IOException;
import javafx.scene.control.Label;



public class ControllerEsercizio2 {

    
        @FXML
        private ImageView goToDashboard;
    
        @FXML
        private Button goToExercise2;

        @FXML
        private Label lblDomanda;

        @FXML
        private Label lblLivello;
    
        @FXML
        void switchToDashboardScene(MouseEvent event) {
             String location = "/project/resources/dashboard/dashboard.fxml";  
       // SceneController.loadFXML(event, "/project/resources/dashboard/dashboard.fxml");

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
            Parent dashboardRoot = loader.load();
    
            SceneController.switchScene((Node) event.getSource(), dashboardRoot);

        }catch(IOException | RuntimeException e){
            SceneController.showControllerError(e, location);
        }
        }
    
        @FXML
        void switchToExercise2(MouseEvent event) {
           SceneController.loadFXML(event, "/project/resources/esercizio2/esercizio2.fxml");    
            
        }   

        public void setLivello(){
            lblLivello.setText("LIVELLO "+ UserScraper.restituisciLivello(1));
        }

        public void setNumeroDomanda(){
            lblDomanda.setText("DOMANDA "+ (UserScraper.getPunteggio(1)+1));
        }

        @FXML
        public void initialize(){
            setLivello();
            setNumeroDomanda();
        }   
}

    
