package versione_1;

import java.io.Serializable;
import java.util.ArrayList;

public class UnitaImmobiliare implements Serializable{
	
	private String destinazione;
	private ArrayList<UnitaDomotica> unitList;
	
	public UnitaImmobiliare(String _destinazione)
	{
		this.destinazione= _destinazione;
		unitList= new ArrayList<>();
	}

	public void setdestinazione(String _destinazione)
	{
		destinazione= _destinazione;
	}
	
	public String getdestinazione()
	{
		return destinazione;
	}
	
	public void addUnitaDomotica(UnitaDomotica unitaDomotica)
	{
		/*if(unitList.isEmpty())
		{
			unitList.add(unitaDomotica);
			return true;
		}
		else if(!unitaDomoticaGiaPresente(unitaDomotica.getUnitName()))
		{
			unitList.add(unitaDomotica);
			return true;
		}
		
		return false;*/
		unitList.add(unitaDomotica);
	}
	
	public boolean verificaPresenzaUnitaDomotica(String nomeUnita, String classType)
	{
		boolean presente = false;
		
		for (UnitaDomotica elemento: unitList)
		{
			//verifica che il nome della stanza esista e che l'elemento in analisi sia di tipo Stanza, ho aggiunto getName perchè se no restituiva solo true o false
			//inoltre ho dovuro mettere la substring perchè getName restituiva: versione_1.Stanza
			if(elemento.getUnitName().equalsIgnoreCase(nomeUnita) && elemento.getClass().getName().substring(11).equals(classType))
				presente= true;
		}
		return presente;
	}
	
	public String[] stampaLista()
	{
		String[] unitaDomotica= new String[unitList.size()];
		
		for(int i=0; i<unitList.size();i++)
		{
			unitaDomotica[i]= unitList.get(i).getUnitName();
		}
		return unitaDomotica;
	}
	
	public UnitaDomotica getUnitaDomotica(int i)
	{
		return unitList.get(i);
	}
	
	public int size()
	{
		return unitList.size();
	}
	
	public ArrayList<UnitaDomotica> getUnitList()
	{
		return unitList;
	}
	
	public boolean isEmpty()
	{
		return unitList.isEmpty();
	}
	
}
