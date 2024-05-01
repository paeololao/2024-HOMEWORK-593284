package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;

public class StanzaBuiaTest {

	private static final String ATTREZZO_LUCE_TEST = "attrezzoLuceTest";
	private StanzaBuia stanzaBuia;
	
	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("StanzaBuia", ATTREZZO_LUCE_TEST);
	}

	@Test
	public void testGetDescrizioneLuceNonPresente() {
		assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
	}
	
	

}
