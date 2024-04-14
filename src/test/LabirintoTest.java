package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class LabirintoTest {
	
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
	}

	@Test
	public void testStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	
	@Test
	public void testLabirintoNonVuoto() {
		assertNotNull(labirinto.getStanzaIniziale());
	}

}
