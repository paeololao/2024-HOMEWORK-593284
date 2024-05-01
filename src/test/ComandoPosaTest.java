package test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.partita.IOConsole;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	
	private static final String ATTREZZO_DA_POSARE = "AttrezzoDaPosare";
	private ComandoPosa comandoPosa;
	private Partita partita;
	private Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		this.comandoPosa = new ComandoPosa();
		this.comandoPosa.setIO(new IOConsole());
		this.partita = new Partita(labirinto);
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_DA_POSARE, 1);
		borsa.addAttrezzo(attrezzoNuovo);
	}

	@Test
	public void testEseguiAttrezzoPresente() {
		this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
		this.comandoPosa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
	}
	
	@Test
	public void testEseguiAttrezzoNonPresente() {
		String nonPresente = "attrezzoNonPresente";
		this.comandoPosa.setParametro(nonPresente);
		this.comandoPosa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(nonPresente));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
	}
	
	@Test
	public void testEseguiStanzaPiena() {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		for (int i = 0; i < Stanza.getNumeroMassimoAttrezzi(); i++) {
			stanzaCorrente.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
		
		this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
		this.comandoPosa.esegui(partita);
		assertFalse(stanzaCorrente.hasAttrezzo(ATTREZZO_DA_POSARE));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
	}
	
}
