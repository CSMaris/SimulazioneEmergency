package it.polito.tdp.emergency;

import java.time.LocalTime;
import java.util.PriorityQueue;

public class TestListaAttesa {

	public static void main(String args[]) {

		PriorityQueue<Paziente> attesa = new PriorityQueue<>(new PazienteComparator());

		LocalTime ora = LocalTime.of(8, 0);

		for (int i = 0; i < 50; i++) {
			Paziente p = new Paziente(i + 1, StatoPaziente.WHITE, ora);
			ora = ora.plusMinutes(5);
			attesa.add(p);
			
			p = new Paziente(i + 1, StatoPaziente.YELLOW, ora);
			ora = ora.plusMinutes(5);
			attesa.add(p);

			p = new Paziente(i + 1, StatoPaziente.RED, ora);
			ora = ora.plusMinutes(5);
			attesa.add(p);

		}
		
		Paziente p ;
		while((p = attesa.poll())!=null) {
			System.out.println(p.getId()+" "+p.getStato()+" "+p.getOraArrivo());
		}
		
		
	}

}
