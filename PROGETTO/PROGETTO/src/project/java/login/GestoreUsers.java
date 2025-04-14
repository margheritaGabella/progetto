package project.java.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;
import project.java.dashboard.UserScraper;

//Questa classe è indipendente dall'interfaccia grafica e si occupa solo della gestione dei dati

//Responsabile della gestione degli utenti in un'applicazione
public class GestoreUsers { //non è necessario creare un'istanza di questa classe per utilizzare perché è una classe static

    private static final String USER_FILE = "data/user.json";
    private static List<User> users = new ArrayList<>(); //lista che contiene tutti gli oggetti User
    

    //eseguito una sola volta quando la classe viene caricata
    static{
        loadUsers(); //carica gli utenti dal file JSON
    }

    //Autenticazione utente
    public static boolean authenticate(String username, String password){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                UserScraper.scraper(0, user.getUsername(), user.getName(), user.getSurname(), user.getPunteggi());
                return true;
            }
        }
        return false;
    }

    //metodo che restituisce utente
    public static String restituisciUser(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user.getUsername();
            }
        }
        return null;
    }

    //Verifica se l'username esiste già
    public static boolean userExists(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true; // Se trova un utente con lo stesso username, restituisce true
            }
        }
        return false;
    }

    //Registrazione utente
    public static void registerUser(String username, String password, String name, String surname){
        //crea un nuovo oggetto user con i dati passati
        User newUser = new User(username, password, name, surname); 

        users.add(newUser); //lo aggiunge alla lista users
        saveUsers(); //salva i dati su un file JSON
    }

    //caricare i dati degli utenti da un file JSON e salvarli nella lista users
    private static void loadUsers() {
        try {
            File file = new File(USER_FILE);
            if (file.exists()) {
                //oggetto della libreria Jackson, che viene usato per convertire dati tra formati Java (oggetti) e JSON (stringhe)
                ObjectMapper mapper = new ObjectMapper();
                User[] usersArray = mapper.readValue(file, User[].class);
                users = new ArrayList<>(Arrays.asList(usersArray));  // Usare ArrayList per rendere la lista modificabile
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Salva gli utenti nel file JSON
    private static void saveUsers(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(USER_FILE), users);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
