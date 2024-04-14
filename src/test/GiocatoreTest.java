package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	private Giocatore giocatore;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}
	
	@Test
	public void testCfuIniziali() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testCambioCfu() {
		giocatore.setCfu(30);
		assertEquals(30, giocatore.getCfu());
	}
	
	@Test
	public void testBorsaEsiste() {
		assertNotNull(giocatore.getBorsa());
	}

}
