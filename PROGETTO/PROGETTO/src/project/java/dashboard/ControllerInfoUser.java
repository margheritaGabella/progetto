
package project.java.dashboard;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.java.general.SceneController;
import javafx.scene.control.Label;

public class ControllerInfoUser {

    @FXML
    private ImageView goToDashboard;

    @FXML
    private Label infoUser1;

    @FXML
    private Label infoUser2;

    @FXML
    private Label infoUser3;


    @FXML
    void switchToDashboardScene(MouseEvent event) {
     try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/resources/dashboard/dashboard.fxml"));
        Parent dashboardRoot = loader.load();
        Scene dashboardScene = new Scene(dashboardRoot);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(dashboardScene);
        stage.show();
    } catch (IOException e) {
        System.err.println("Errore durante il caricamento della dashboard: " + e.getMessage());
        e.printStackTrace();
    }
    }

    public void readInfo() {
        // Ottiene il nome utente dal UserScraper
        String username = UserScraper.getUsername();
        String name = UserScraper.getName();
        String surname = UserScraper.getSurname();

    
        if (username != null && infoUser1 != null) {
            infoUser1.setText("username: " + username);
            infoUser2.setText("nome: " + name);
            infoUser3.setText("cognome: " + surname); //setta la sritta di benvenuto nella dashbord
        } else {
            System.out.println("Nessun utente loggato.");
        }
    }

    @FXML
    public void initialize(){
        readInfo();
    }


}
