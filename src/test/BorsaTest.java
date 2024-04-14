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
	private Attrezzo attrezzoNonPresente;
	
	@Before
	public void setUp() {
		this.borsaVuota = new Borsa();
		this.borsaNonVuota = new Borsa();
		this.attrezzoPresente = new Attrezzo("ci sono", 4);
		this.borsaNonVuota.addAttrezzo(attrezzoPresente);
		this.attrezzoNonPresente = new Attrezzo("non ci sono", 6);
		
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
	public void testBorsaConAttrezzoNonPresente() {
		assertNotEquals(this.borsaNonVuota.getAttrezzo("non ci sono").getNome(), this.attrezzoNonPresente.getNome());
	}

}
