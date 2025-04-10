package project.java.login;

import project.java.dashboard.ControllerDashboard;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import project.java.general.SceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import java.io.IOException;

//gestisce il login e la registrazione degli utenti per un'applicazione JavaFX.
//Salva e carica gli utenti da un file JSON (data/user.json) utilizzando Jackson per la gestione dei file JSON.
public class ControllerLogin{

    //private static final String JSON_FILE = "data/user.json"; //percorso del file JSON che memorizza gli utenti
    //private static final ObjectMapper objectMapper = new ObjectMapper(); //istanza di jackson per leggere/scrivere file JSON

    @FXML 
    private TextField usernameSignup;

    @FXML
    private TextField passwordSignup;

    @FXML
	private TextField nameSignup;
	
	@FXML
	private TextField surnameSignup;
	
	@FXML
	private TextField usernameLogin;
	
	@FXML
	private TextField passwordLogin;
	
	@FXML
	private Label errorMessageLogin;
	
	@FXML
	private Label errorMessageSignup;

    @FXML
	private Label welcomeTextDashboard;

    public String userWelcome = "";
    

    //prende username
    /*public String getUserWelcome(){
        return userWelcome;
    }
    
    public void setWelcomeText() {
        welcomeTextDashboard.setText("Ciao " + getUserWelcome() + "!"); 
        
    }*/

    //passaggio alla scena Login
    public void switchToLoginScene(ActionEvent event){
        SceneController.loadFXML(event, "/project/resources/login/login.fxml");
    }

    //passaggio alla scena Registrazione
    public void switchToSignupScene(ActionEvent event){
        SceneController.loadFXML(event, "/project/resources/login/signup.fxml");
    }
    //passaggio alla scena dashboard
    public void switchToDashboardScene(ActionEvent event){
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

    //gestione del login
    public void login(ActionEvent event){
        String username = usernameLogin.getText();
        String password = passwordLogin.getText();
        
        //controlla che i campi non siano vuoti
        if(username.isEmpty() || password.isEmpty()){
            errorMessageLogin.setText("Dati mancanti");
            return;
        }
    

        //gestione login
        if(GestoreUsers.authenticate(username, password)){
           
            switchToDashboardScene(event);
            
        }else{
            errorMessageLogin.setText("Credenziali non valide");
        }

        //userWelcome = usernameLogin.getText();
    }


    //gestione del signup
    public void signup(ActionEvent event){
        String username = usernameSignup.getText();
        String password = passwordSignup.getText();
        String name = nameSignup.getText();
        String surname = surnameSignup.getText();
        
        //controlla che tutti i campi non siano vuoti 
        if(username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty()){
            errorMessageLogin.setText("Dati mancanti");
            return;
        }

        //Verifica se l'utente esiste già
        if(GestoreUsers.userExists(username)){
            errorMessageSignup.setText("Username già esistente");
            return;
        }

        //registrazione utente
        GestoreUsers.registerUser(username, password, name, surname);
        switchToLoginScene(event);
        SceneController.showAlertWindow("Registrazione avvenuta con successo", "Ora puoi procedere con il login");
    }
}




