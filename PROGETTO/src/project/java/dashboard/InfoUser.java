
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


public class InfoUser {

    @FXML
    private ImageView goToDashboard;

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

}
