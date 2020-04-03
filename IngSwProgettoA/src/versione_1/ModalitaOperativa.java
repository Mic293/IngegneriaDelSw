package versione_1;

import java.io.Serializable;

public class ModalitaOperativa implements Serializable {
	
	private String nomeModOperativa;
	private String descrizione;
	
	public ModalitaOperativa(String _nomeModOperativa, String _descrizione)
	{
		this.nomeModOperativa=_nomeModOperativa;
		this.descrizione=_descrizione;
	}
	
	public void setNomeModOperativa(String _nomeModOp)
	{
		this.nomeModOperativa=_nomeModOp;
	}
	
	public void setDescrizione(String _descrizione)
	{
		this.descrizione=_descrizione;
	}
	
	public String getNomeModOperativa()
	{
		return nomeModOperativa;
	}
	
	public String getDescrizione()
	{
		return descrizione;
	}
	
	
}
