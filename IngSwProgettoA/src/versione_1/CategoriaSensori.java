package versione_1;



import java.util.ArrayList;
import java.util.Map;

import it.unibs.fp.mylib.ServizioFile;

public class CategoriaSensori extends Categoria {

	private ArrayList<InfoRilevabile> infoRilevabili;

	
	public CategoriaSensori(String nomeCategoria, String descrizione, ArrayList<InfoRilevabile> infoRilevabili){
		super(nomeCategoria, descrizione);
		if(infoRilevabili.isEmpty())
			throw new IllegalStateException("Non può essere vuota");
		this.infoRilevabili = new ArrayList<InfoRilevabile>();
	}
	
	public CategoriaSensori()
	{
		this.infoRilevabili = new ArrayList<InfoRilevabile>();
	}
	public void setNomeCategoria(String nome)
	{
		super.setNomeCategoria(nome);
	}
	
	public String getNomeCategoria()
	{
		return super.getNomeCategoria();
	}
	
	public void addInfoRilevabili(InfoRilevabile infoRilevabile)
	{
		
			infoRilevabili.add(infoRilevabile);
		
	}
	
	public boolean removeInfoRilevabili(InfoRilevabile infoRilevabile)
	{
		if(infoGiaPresente(infoRilevabile.getTipoInfoRilevabile()))
		{
			infoRilevabili.remove(infoRilevabile);
			return true;
		}
		return false;
	}
	
	public boolean infoGiaPresente(String infoRilevabile)
	{
		for(int i =0; i<infoRilevabili.size();i++)
		{
			if(infoRilevabile.equalsIgnoreCase(infoRilevabili.get(i).getTipoInfoRilevabile()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String[] stampaInfoRilevabili()
	{
		String[] informazioni= new String[infoRilevabili.size()];
		
		for(int i=0; i<infoRilevabili.size();i++)
		{
			informazioni[i]= infoRilevabili.get(i).getTipoInfoRilevabile();
		}
		return informazioni;
	}
	
	public int size()
	{
		return infoRilevabili.size();
	}
	
	public InfoRilevabile getInfoRilevabile(int i)
	{
		return infoRilevabili.get(i);
	}
	
	public void setValoreInfoRilevabile(String nome, int valore, String infoRilavabile)
	{
		boolean presente = false;
		for(int i =0;i<infoRilevabili.size() && !presente;i++)
		{
			if(infoRilevabili.get(i).getTipoInfoRilevabile().equalsIgnoreCase(infoRilavabile))
			{
				infoRilevabili.get(i).addMisurazione(nome, valore);
				presente=true;
			}
				
		}	
	}
	
	
}
