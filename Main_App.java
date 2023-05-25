import java.util.Arrays;

/**
 * Classe Main con uso di due vettori
 * (medie voti e risultato, nella stessa cella compare la media voto e il
 * risultato dello stesso alunno) e metodi con parametri
 * Sviluppato a (scuola, casa, etc)
 * 
 * @author
 * @version 1.0
 */
public class Main_App {

	private static final char risultati_validi[] = { 'A', 'S', 'N' };
	static float voti[] = { 5.5f, 6.0f, 7.0f, 7.4f, 4.0f, 5.9f, 6.3f, 8.4f, 9.2f, 5.2f }; // voti voto[0] corrisponde
																							// risultato[0]
	static char risultati[] = { 'S', 'A', 'A', 'A', 'N', 'S', 'A', 'A', 'A', 'S' }; // risultati di fino anno
	// Legenda risultati
	// 'N' non ammesso
	// 'S' sospensione del giudizio
	// 'A' ammesso

	public static void main(String args[]) {
		// stampa vettore con format
		visualizzaVettore();
		percentualealunniA_S_N();
	}

	/**
	 * Visualizza il vettore dalla posizione 0 alla posizione DIM - 1 con format
	 */
	private static void visualizzaVettore() {
		System.out.print("*-VALUTAZIONI-ALUNNI-*\n");
		for (int i = 0; i < voti.length; i++) {
			switch (risultati[i]) {
				case 'A':
					System.out.format("Alunno [%-3d] -> Media %.1f | AMMESSO\n", i + 1, voti[i]);
					break;
				case 'S':
					System.out.format("Alunno [%-3d] -> Media %.1f | DA DECIDERE\n", i + 1, voti[i]);
					break;
				case 'N':
					System.out.format("Alunno [%-3d] -> Media %.1f | RIMANDATO\n", i + 1, voti[i]);
					break;
			}
		}
		// da migliorare con al posto della lettera, deve comparire il risultato per
		// esteso -- vedi Legenda risultati
	}

	/**
	 * @param risultato
	 * @return
	 * @throws CharNotSupported
	 */
	static int alunniGenerale(char risultato) throws CharNotSupported {
		boolean in = false;
		for (char c : risultati_validi) {
			in = c == risultato;
			if (in) {
				break;
			}
		}
		if (!in) {
			throw new CharNotSupported("carattere " + risultato + " non valido, deve essere tra i seguenti: "
					+ Arrays.toString(risultati_validi));
		}
		int idx = 0;
		for (char c : risultati) {
			if (c == risultato)
				idx++;
		}
		return idx;
	}

	/** 
	 * stampa in % gli alunni ammessi, da decidere e non promossi
	 * */ 
	static void percentualealunniA_S_N() {
		int mx = risultati.length;
		int A = 0, S = 0, N = 0;
		for (char c : risultati) {
			switch (c) {
				case 'A':
					A++;
					break;
				case 'S':
					S++;
					break;
				case 'N':
					N++;
					break;
			}
		}
		System.out.printf("*-RESOCONTO-*\n| Ammessi: %d%%\n| Da decidere: %d%%\n| Rimandati: %d%%\n",
				(int) ((float) A / (float) mx * 100), (int) ((float) S / (float) mx * 100),
				(int) ((float) N / (float) mx * 100));
	}
	/**
	 * @todo fare i seguenti metodi
	 */
	// 1)
	// migliorare static void visualizzaVettore()
	// specificare meglio il risultato (risultato per esteso)

	// 2)
	// static int alunniGenerale( char risultato)
	// metodo che restituisce a seconda del carattere risultato (che può esssere
	// 'A','S','R') il numero di alunni corrispondente
	// cercare di gestire la soluzione di un char risultato non valido ad esempio
	// 'O'

	// 3)
	// static void percentualealunniA_S_N ()
	// metodo che stampa le tre percuentuali dei tre diversi tipologie di risultati
	// esempio di stampa
	// Nella classe sono Ammessi: 33% Sospesi: 33% Respinti: 34%
	// ripeto è solo un esempio.

}
