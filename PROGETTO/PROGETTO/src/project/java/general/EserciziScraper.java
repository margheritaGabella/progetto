package project.java.general;

public class EserciziScraper {
    
        private static int idEsercizio = 0;
        private static int livello = 0;
        private static String domanda = null;
        private static String[] possibiliRisposte = null;
        private static String rispostaEsatta = null;
        private static String motivazione = null;
        
        public static void scraper(int idEsercizio, int livello, String domanda, String[] possibiliRisposte, String rispostaEsatta, String motivazione) {
            EserciziScraper.idEsercizio = idEsercizio;
            EserciziScraper.livello = livello;
            EserciziScraper.domanda = domanda;
            EserciziScraper.possibiliRisposte = possibiliRisposte;
            EserciziScraper.rispostaEsatta = rispostaEsatta;
            EserciziScraper.motivazione = motivazione;

        }

        public static int getIdEsercizio() {
            return idEsercizio;
        }


        public static int getLivello() {
            return livello;
        }
        
        public static String getDomanda() {
            return domanda;
        }
        
        public static String[] getPossibiliRisposte() {
            return possibiliRisposte;
        }
        
        public static String getRispostaEsatta() {
            return rispostaEsatta;
        }
    
        public static String getMotivazione() {
            return motivazione;
        }

        //

}
