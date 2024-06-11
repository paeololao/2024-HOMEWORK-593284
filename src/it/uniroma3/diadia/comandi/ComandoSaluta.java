package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private IO io;
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Ciao, sono Paolo");
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Ah non c'e' alcun personaggio in questa stanza!");
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
