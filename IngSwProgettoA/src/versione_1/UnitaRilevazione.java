package versione_1;

import java.io.Serializable;

public abstract class UnitaRilevazione implements Serializable{
	
	private String nomeUnita;
	private Stato stato;
	private Categoria categoria;
	private UnitaDomotica unitaDomotica;
	
	public UnitaRilevazione(String nomeUnita) {
		if(!nomeUnita.matches("[A-Za-z]+[0-9][1-9]*_[a-zA-Zàèìòù]+")) //perchè il nome deve essere costituito: nome fantasia_nome categoria
			throw new IllegalStateException("Nome non valido");
		this.nomeUnita = nomeUnita;
		this.stato = stato.ACCESO;
	}
	public UnitaRilevazione()
	{
		
	}
	
	public void setNomeUnita(String _nomeUnita)
	{
		if(!_nomeUnita.matches("[A-Za-z]+[0-9][1-9]*_[a-zA-Zàèìòù]+")) //perchè il nome deve essere costituito: nome fantasia_nome categoria
			throw new IllegalStateException("Nome non valido");
		this.nomeUnita = _nomeUnita;
	}
	
	public String getNomeUnita()
	{
		return nomeUnita;
	}
	
	public void setCategoria(Categoria _categoria)
	{
		categoria=_categoria;
	}
	
	public Categoria getCategoria()
	{
		return categoria;
	}
	
	public void setUnitaDomotica(UnitaDomotica _unitaDomotica)
	{
		unitaDomotica= _unitaDomotica;
	}
	
	public UnitaDomotica getUnitaDomotica()
	{
		return unitaDomotica;
	}
	
	public Stato getStato()
	{
		return stato;
	}
}
