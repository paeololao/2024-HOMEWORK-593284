package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;


public class StanzaBloccataTest {

	private static final String STANZA_ADIACENTE_LIBERA = "stanzaAdiacenteLibera";
	private static final String STANZA_ADIACENTE_BLOCCATA = "stanzaAdiacenteBloccata";
	private static final String DIREZIONE_BLOCCATA = "DirBloccata";
	private static final String DIREZIONE_LIBERA = "DirLibera";
	private static final String CHIAVE_TEST = "chiaveTest";
	private static final String STANZA_BLOCCATA = "StanzaBloccata";
	
	private StanzaBloccata stanzaBloccata;

	@Before
	public void setUp() {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(STANZA_BLOCCATA, CHIAVE_TEST, DIREZIONE_BLOCCATA);
		this.stanzaBloccata = stanzaBloccata;
	}

	private void setStanzeAdiacenti(Stanza stanzaBloccata) {
		Stanza stanzaAdiacenteLibera = new Stanza(STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza(STANZA_ADIACENTE_BLOCCATA);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
	}
	
	@Test
	public void testGetStanzaAdiacenteBloccata() {
		setStanzeAdiacenti(this.stanzaBloccata);
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	
	@Test
	public void testGetStanzaAdiacenteLibera() {
		setStanzeAdiacenti(this.stanzaBloccata);
		assertEquals(STANZA_ADIACENTE_LIBERA, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_LIBERA).getNome());
	}
	
	
}
