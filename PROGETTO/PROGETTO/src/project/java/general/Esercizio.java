package project.java.general;
import java.io.*;



// classe per salvare le informazioni degli esercizi
public class Esercizio {
	private int tipoEsercizio;
	private int livello;
	private String testo;
	//private String[] possibiliRisposte;
	private String rispostaEsatta;
	private String motivazione;
	
	public Esercizio() {
        // Jackson needs this
    }
	
	public Esercizio(int tipoEsercizio, int livello, String testo, String rispostaEsatta, String motivazione) {
		this.tipoEsercizio = tipoEsercizio;
		this.livello = livello;
		this.testo = testo;
		//this.possibiliRisposte = possibiliRisposte;
		this.rispostaEsatta = rispostaEsatta;
		this.motivazione = motivazione;
		
	}
	
	public int getTipoEsercizio() {
		return this.tipoEsercizio;
	}
	
	public int getLivello() {
		return this.livello;
	}
	
	public String getTesto() {
		return this.testo;
	}
	
	//public String[] possibiliRisposte() {
		//return this.possibiliRisposte;
	//}

	public String getRispostaEsatta() {
		return this.rispostaEsatta;
	}

	public String getmotivazione() {
		return this.motivazione;
	}
	
	@Override
    public String toString() {
		return getTesto();
	}
	
}