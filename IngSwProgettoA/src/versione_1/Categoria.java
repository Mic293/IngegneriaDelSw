package versione_1;

import java.io.Serializable;

public abstract class Categoria implements Serializable { //Astratta, non istanziabile

	private String nomeCategoria;
	private String descrizione; //se non piace stringa si può trovare alternativa
	private static final int MAX_CARATTERI = 144; 
	
	public Categoria(String nomeCategoria, String descrizione)
	{
		this.nomeCategoria = nomeCategoria;
		if(descrizione.length() > MAX_CARATTERI)
			throw new IllegalStateException("Descrizione troppo lunga"); //prog difensiva
		this.descrizione = descrizione;		
	}
	public Categoria()
	{
		
	}
	
	public void setNomeCategoria(String nomeCategoria)
	{
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getNomeCategoria()
	{
		return nomeCategoria;
	}
	
	public void setDescrizioneCategoria(String descrizioneCategoria)
	{
		this.descrizione = descrizioneCategoria;
	}
	
	public String getDescrizioneCategoria()
	{
		return descrizione;
	}
	
	
	
}
