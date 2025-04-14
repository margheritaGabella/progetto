
package project.java.dashboard;

// classe con soli metodi statici per salvare a tempo di esecuzione i dati dell'utente che accede
public class UserScraper {
	private static int idUser = 0;
	private static String username = null;
	private static String name = null;
	private static String surname = null;
	private static int[] punteggi = {0, 0, 0};
	
	public static void scraper(int idUser, String username, String name, String surname, int[] punteggi) {
		UserScraper.idUser = idUser;
		UserScraper.username = username;
		UserScraper.name = name;
		UserScraper.surname = surname;
		UserScraper.punteggi = punteggi;
	}
	
	public static int getIdUser() {
		return idUser;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getSurname() {
		return surname;
	}

	public static int[] getPunteggi() {
		return punteggi;
	}
	
	// metodo per svuotare i dati, viene chiamato al momento del logout dell'utente
	public static void removeInfo() {
		idUser = 0;
		username = null;
		name = null;
		surname = null;
		//punteggi = {0, 0, 0};
	}

	//metodo per scrivere livelli
	public static String restituisciLivello(int tipoEsercizio) {
		if(punteggi[tipoEsercizio] >= 0 && punteggi[tipoEsercizio]<=2){
			return "PRINCIPIANTI";
		} else if(punteggi[tipoEsercizio] >= 3 && punteggi[tipoEsercizio]<=5){
			return "INTERMEDIO";
		} else {
			return "ESPERTO";
		}
	}

	//metodo che restituisce il punteggio corrente per tipo esercizio
	public static int getPunteggio(int tipoEsercizio) {
		return punteggi[tipoEsercizio];
	}

}



