package project.java.general;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class GestoreEsercizio {
    private static final String ES_FILE1 = "data/esercizio1.json";
    private static List<Esercizio> es1 = new ArrayList<>();

    private static final String ES_FILE2 = "data/esercizio2.json";
    private static List<Esercizio> es2 = new ArrayList<>();

    private static final String ES_FILE3 = "data/esercizio3.json";
    private static List<Esercizio> es3 = new ArrayList<>();

    static{
        loadEsercizio(); //carica l'esercizio 1 dal file JSON
    }

    //caricare i dati dell'esercizio 1 da un file JSON
    private static void loadEsercizio() {
        try {
            File file = new File(ES_FILE1);
            if (file.exists()) {
                //oggetto della libreria Jackson, che viene usato per convertire dati tra formati Java (oggetti) e JSON (stringhe)
                ObjectMapper mapper = new ObjectMapper();
                Esercizio[] eserciziArray = mapper.readValue(file, Esercizio[].class);
                es1 = new ArrayList<>(Arrays.asList(eserciziArray));  // Usare ArrayList per rendere la lista modificabile
                System.out.println("Loaded " + es1.size() + " exercises");

            } else {
                System.err.println("File does not exist: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error loading exercises: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //metodo che restituisce esercizio 
   public static Esercizio getEsercizio(int tipoEsercizio, int punteggio) {
        switch (tipoEsercizio) {
            case 0:
                return es1.get(punteggio);
            case 1:
                return es2.get(punteggio);
            case 2:
                return es3.get(punteggio);
            default:
                return null;
        }
    }


    
}
