package project.java.dashboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;

import project.java.general.SceneController;
import project.java.login.GestoreUsers;
import project.java.login.User;
import project.java.login.ControllerLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ControllerDashboard {
	
    @FXML
	private Label welcomeTextDashboard;

    @FXML
    private Button goToExercise1Home;

    @FXML
    private Button goToExercise2Home;

    @FXML
    private Button goToExercise3Home;

    @FXML
    private ImageView goToInfo;

    @FXML
    private ImageView goToLogin;

    @FXML
    private ProgressBar barra1;

    @FXML
    private ProgressBar barra2;

    @FXML
    void switchToExercise1Home(MouseEvent event) {
        String location = "/project/resources/esercizio1/homeEsercizio1.fxml";  
        // SceneController.loadFXML(event, "/project/resources/dashboard/dashboard.fxml");
 
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
             Parent esercizio1Root = loader.load();
     
             //setWelcomeText();
             SceneController.switchScene((Node) event.getSource(), esercizio1Root);
 
         }catch(IOException | RuntimeException e){
             SceneController.showControllerError(e, location);
         }
    }

   @FXML
    void switchToExercise2Home(MouseEvent event) {
        String location = "/project/resources/esercizio2/homeEsercizio2.fxml";  
        // SceneController.loadFXML(event, "/project/resources/dashboard/dashboard.fxml");
 
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
             Parent esercizio2Root = loader.load();
             SceneController.switchScene((Node) event.getSource(), esercizio2Root);

 
         }catch(IOException | RuntimeException e){
             SceneController.showControllerError(e, location);
         }
    }

    @FXML
    void switchToExercise3Home(MouseEvent event) {

    }


    @FXML
    void switchToInfoScene(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/resources/dashboard/InfoUser.fxml"));
            Parent infoRoot = loader.load();
            Scene InfoScene = new Scene(infoRoot);
    
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(InfoScene);
            stage.show();

        } catch (IOException e) {
            System.err.println("Errore durante il caricamento della schermata di info sull'utente: " + e.getMessage());
            e.printStackTrace();
        }
    }
    


    @FXML
    void switchToLoginScene(MouseEvent event) {

        UserScraper.removeInfo(); //cancella dati utente salvati a tempo di esecuzione

        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/resources/login/login.fxml"));
        Parent loginRoot = loader.load();
        Scene loginScene = new Scene(loginRoot);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginScene);
        stage.show();
    } catch (IOException e) {
        System.err.println("Errore durante il caricamento della schermata di login: " + e.getMessage());
        e.printStackTrace();
    }
}

    public void readUsername() {
        // Ottiene il nome utente dal UserScraper
        String username = UserScraper.getUsername();
    
        if (username != null && welcomeTextDashboard != null) {
            welcomeTextDashboard.setText("Ciao " + username + "!"); //setta la sritta di benvenuto nella dashbord
        } else {
            System.out.println("Nessun utente loggato.");
        }
    }

    //metodo per aggiornare progressBar
    public void aggiornaBarra(){
        barra1.setProgress(UserScraper.getPunteggi()[0]*0.125);
        barra2.setProgress(UserScraper.getPunteggi()[1]*0.125);
    }

    //metodo per bloccare i tasti dopo che ssono stati superati tutti gli esercizi
    public void bloccaTasti(){
        if(UserScraper.getPunteggi()[0] == 8){
            goToExercise1Home.setDisable(true);
        } else if(UserScraper.getPunteggi()[1] == 8){
            goToExercise2Home.setDisable(true);
        }
    }

    @FXML
    public void initialize(){
        readUsername();
        aggiornaBarra();
        bloccaTasti();
    }


}
