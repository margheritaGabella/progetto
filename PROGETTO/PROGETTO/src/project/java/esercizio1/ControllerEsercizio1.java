package project.java.esercizio1;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import project.java.dashboard.UserScraper;
import project.java.general.Esercizio;
import project.java.general.GestoreEsercizio;
import project.java.general.SceneController;
import javafx.scene.control.Label;



public class ControllerEsercizio1 {
    
    
        @FXML
        private ImageView goToDashboard;
    
        @FXML
        private Button goToExercise1;

        @FXML
        private TextArea testoDomanda; 

        @FXML
        private Label lblDomanda;

        @FXML
        private Label lblLivello;

        @FXML
        private Button goToValutazioneIntermedia;
    
        @FXML
        void switchToDashboardScene(MouseEvent event) {
             String location = "/project/resources/dashboard/dashboard.fxml";  
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
            Parent dashboardRoot = loader.load();
            SceneController.switchScene((Node) event.getSource(), dashboardRoot);

        }catch(IOException | RuntimeException e){
            SceneController.showControllerError(e, location);
        }
        }
    
        @FXML
        void switchToExercise1(MouseEvent event) {
            String location = "/project/resources/esercizio1/esercizio1.fxml";
            try{
                if(UserScraper.getPunteggio(0) == 2 || UserScraper.getPunteggio(0) == 5 || UserScraper.getPunteggio(0) == 8){
                    goToExercise1.setDisable(true);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
                    Parent esercizio1Root = loader.load();
                    SceneController.switchScene((Node) event.getSource(), esercizio1Root);
                }
    
            }catch(IOException | RuntimeException e){
                SceneController.showControllerError(e, location);
            }
            
        }

        @FXML
        void switchToValutazioneIntermedia(MouseEvent event) {
            String location = "/project/resources/esercizio1/valutazioneIntermedia1.fxml";
            try{
                if(UserScraper.getPunteggio(0) == 2 || UserScraper.getPunteggio(0) == 5 || UserScraper.getPunteggio(0) == 8){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
                    Parent valutazioneIntermediaRoot = loader.load();
                    SceneController.switchScene((Node) event.getSource(), valutazioneIntermediaRoot);
                } else {
                    goToValutazioneIntermedia.setDisable(true);
                } 
    
            }catch(IOException | RuntimeException e){
                SceneController.showControllerError(e, location);
            }
            
        }

        public void setLivello(){ //metodo per visualizzare il livello 
            lblLivello.setText("LIVELLO "+ UserScraper.restituisciLivello(0));
        }

        public void setNumeroDomanda(){ //metodo per visualizzare il numero della domanda 
            lblDomanda.setText("DOMANDA "+ (UserScraper.getPunteggio(0)+1));
        }

        public void setDomanda(){ //metodo per visualizzare il testo della domanda 
            Esercizio e = GestoreEsercizio.getEsercizio(0, UserScraper.getPunteggio(0));
            
            //System.out.println(e.toString());
            testoDomanda.setText(e.toString());
        }

        @FXML
        public void initialize(){
            setLivello(); //aggiorniamo il livello sull'interfaccia dell'esercizio 
            setNumeroDomanda(); //aggiorniamo il numero della domanda sull'interfaccia dell'esercizio
            setDomanda(); //aggiorniamo il testo sull'interfaccia dell'esercizio 

        }   
        
    
    }
    
