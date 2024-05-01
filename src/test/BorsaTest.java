package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private Borsa borsaVuota;
	private Borsa borsaNonVuota;
	private Attrezzo attrezzoPresente;
	private Attrezzo attrezzoDaCancellare;
	
	@Before
	public void setUp() {
		this.borsaVuota = new Borsa();
		this.borsaNonVuota = new Borsa();
		this.attrezzoDaCancellare = new Attrezzo("cancellami", 3);
		this.borsaNonVuota.addAttrezzo(attrezzoDaCancellare);
		this.attrezzoPresente = new Attrezzo("ci sono", 2);
		this.borsaNonVuota.addAttrezzo(attrezzoPresente);	
		this.borsaNonVuota.removeAttrezzo("cancellami");
		
		
	}

	@Test
	public void testBorsaVuota() {
		assertTrue(this.borsaVuota.isEmpty());
	}

	@Test
	public void testBorsaConAttrezzoPresente() {
		assertNotNull(this.borsaNonVuota.getAttrezzo("ci sono"));
	}
	
	@Test
	public void testCancellazione() {
		assertNull(this.borsaNonVuota.getAttrezzo("cancellami"));
	}
	

}
