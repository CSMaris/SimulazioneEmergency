package it.polito.tdp.emergency;

import java.util.Comparator;

/**
 * Confronta due pazienti nella lista d'attesa, in funzione della regola di
 * priorit� definita: i pazienti con un codice di colore pi� grave sono pi�
 * urgenti. A parit� di codice colore, invece, si considera l'orario di arrivo.
 * 
 * @author Fulvio
 *
 */
public class PazienteComparator implements Comparator<Paziente> {

	/**
	 * Confronta applicando la priorit�.
	 * Deve restituire:
	 *  <0 se paz1 ha la priorit�
	 *  >0 se paz2 ha la priorit�
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
