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
    private StackPane goToExercise1;

    @FXML
    private StackPane goToExercise2;

    @FXML
    private StackPane goToExercise3;

    @FXML
    private ImageView goToInfo;

    @FXML
    private ImageView goToLogin;

   @FXML
    void switchToExercise1(MouseEvent event) {
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

   /* @FXML
    void switchToExercise2(MouseEvent event) {

    }

    @FXML
    void switchToExercise3(MouseEvent event) {

    }
*/






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

        //UserScraper.removeInfo(); //cancella dati utente salvati a tempo di esecuzione

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




}
