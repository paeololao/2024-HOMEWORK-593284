package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class PartitaTest {
	
	private Partita partitaTest;
	
	
	@Before
	public void setUp() {
		Labirinto labirintoTest= new Labirinto();
		this.partitaTest=new Partita(labirintoTest);
	}

	@Test
	public void testStanzaVincente() {
		assertEquals("Biblioteca", partitaTest.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testPartitaFinita() {
		assertFalse(partitaTest.isFinita());
	}

	@Test
	public void testStanzaIniziale() {
		assertEquals("Atrio", partitaTest.getStanzaCorrente().getNome());
	}

}
