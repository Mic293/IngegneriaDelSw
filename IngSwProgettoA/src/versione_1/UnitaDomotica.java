package versione_1;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class UnitaDomotica implements Serializable{
	
	//private ArrayList<Sensore> sensList;
	//private ArrayList<Attuatore> attList;
	private String unitName;
	
	public UnitaDomotica(String unitName)
	{
		this.unitName = unitName;
		//sensList = new ArrayList<>();
		//attList = new ArrayList<>();	
	}
	
	public UnitaDomotica()
	{
		//sensList = new ArrayList<>();
		//attList = new ArrayList<>();
	}
	
	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}
	
	public String getUnitName()
	{
		return unitName;
	}
	
	/*public boolean addSensore(Sensore sensore)
	{
		if(sensList.isEmpty())
		{
			sensList.add(sensore);
			return true;
		}
			
		else if(!sensoreGiaPresente(sensore.getCategoria().getNomeCategoria()))
		{
			sensList.add(sensore);
			return true;
		}
		return false;
	}
	
	public boolean removeSensore(Sensore sensore)
	{
		if(sensoreGiaPresente(sensore.getCategoria().getNomeCategoria()))
		{
			sensList.remove(sensore);
			return true;
		}
		return false;
	}
	
	public boolean addAttuatore(Attuatore attuatore)
	{
		if(attList.isEmpty())
		{
			attList.add(attuatore);
			return true;
		}
			
		else if(!attuatoreGiaPresente(attuatore.getCategoria().getNomeCategoria()))
		{
			attList.add(attuatore);
			return true;
		}
		return false;
	}
	
	public boolean removeAttuatore(Attuatore attuatore)
	{
		if(attuatoreGiaPresente(attuatore.getCategoria().getNomeCategoria()))
		{
			attList.remove(attuatore);
			return true;
		}
		return false;
	}
	
	public boolean sensoreGiaPresente(String nomeCategoria)
	{

		boolean presente = false;
		for(int i =0;i<sensList.size() && !presente; i++)
		{
			if(nomeCategoria.equalsIgnoreCase(sensList.get(i).getCategoria().getNomeCategoria()))
				presente = true;
		}
		return presente;
	}
	
	public boolean attuatoreGiaPresente(String nomeCategoria)
	{
		boolean presente = false;
		for(int i =0;i<attList.size() && !presente; i++)
		{
			if(nomeCategoria.equalsIgnoreCase(attList.get(i).getCategoria().getNomeCategoria()))
				presente = true;
		}
		return presente;
	}
	
	public String[] stampaListaSensori()
	{
		String[] sensori= new String[sensList.size()];
		
		for(int i=0; i<sensList.size();i++)
		{
			sensori[i]= sensList.get(i).getCategoria().getNomeCategoria();
		}
		return sensori;
	}
	
	public String[] stampaListaAttuatori()
	{
		String[] attuatori= new String[attList.size()];
		
		for(int i=0; i<attList.size();i++)
		{
			attuatori[i]= attList.get(i).getCategoria().getNomeCategoria();
		}
		return attuatori;
	}*/
	
	
		
}
