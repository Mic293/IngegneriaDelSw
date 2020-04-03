package versione_1;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaCategorie implements Serializable{

	private ArrayList<Categoria> listaCategorie;
	
	public ListaCategorie()
	{
		listaCategorie = new ArrayList <Categoria>();
	}
	
	public String[] stampaLista()
	{
		String[] nomiCategorie = new String[listaCategorie.size()];
		
		
		for(int i=0; i<listaCategorie.size(); i++)
		{
			nomiCategorie[i] = listaCategorie.get(i).getNomeCategoria();
		}
		
		return nomiCategorie;
	}
	 
	public boolean addCategoria(Categoria categoria)
	{
		if(listaCategorie.isEmpty())
		{
			listaCategorie.add(categoria);
			return true;
		}
		else if(!categoriaGiaPresente(categoria.getNomeCategoria()))
		{
			listaCategorie.add(categoria);
			return true;
		}
		
		return false;
	}
	public boolean removeCategoria(Categoria categoria)
	{
		if(!listaCategorie.isEmpty())
		{
			listaCategorie.remove(categoria);
			return true;
		} 
		
		return false;
	}
	 
	public boolean categoriaGiaPresente(String nomeCategoria)
	{
		
		boolean presente = false;
		
		
		for(int i=0; i<listaCategorie.size() && !presente;i++)
		{
			if(listaCategorie.get(i).getNomeCategoria().equalsIgnoreCase(nomeCategoria))
			{
				presente=true;
			}
		}
		
		return presente;
	}
	
	public int size() 
	{
		return listaCategorie.size();
	}
	
	public Categoria getElemento(int i)
	{
		return listaCategorie.get(i);
	}
	 
	 
}
