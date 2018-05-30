package it.polito.tdp.emergency;

import java.util.Comparator;

/**
 * Confronta due pazienti nella lista d'attesa, in funzione della regola di
 * priorità definita: i pazienti con un codice di colore più grave sono più
 * urgenti. A parità di codice colore, invece, si considera l'orario di arrivo.
 * 
 * @author Fulvio
 *
 */
public class PazienteComparator implements Comparator<Paziente> {

	/**
	 * Confronta applicando la priorità.
	 * Deve restituire:
	 *  <0 se paz1 ha la priorità
	 *  >0 se paz2 ha la priorità
	 * @param paz1 paziente 1
	 * @param paz2 paziente 2
	 */
	@Override
	public int compare(Paziente paz1, Paziente paz2) {
		if (paz1.getStato() == paz2.getStato()) {
			return paz1.getOraArrivo().compareTo(paz2.getOraArrivo());
		}
		if (paz1.getStato() == StatoPaziente.RED)
			return -1;
		if (paz2.getStato() == StatoPaziente.RED)
			return +1;
		if (paz1.getStato() == StatoPaziente.YELLOW)
			return -1;
		if (paz2.getStato() == StatoPaziente.YELLOW)
			return +1;

		throw new IllegalArgumentException(
				"Stato paziente non accettabile: " + paz1.getStato() + "-" + paz2.getStato());
	}

}
