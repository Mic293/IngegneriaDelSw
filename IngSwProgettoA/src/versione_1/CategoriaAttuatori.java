package versione_1;


import java.util.ArrayList;

public class CategoriaAttuatori extends Categoria{

	private ArrayList<ModalitaOperativa> listaModOperative;
	
	public CategoriaAttuatori(String nomeCategoria, String descrizione, ArrayList<ModalitaOperativa> listModOperativa){
		super(nomeCategoria, descrizione);
		if(listModOperativa.isEmpty())
			throw new IllegalStateException("Non può essere vuota");
		this.listaModOperative = listModOperativa;				
	}
	
	public CategoriaAttuatori()
	{
		this.listaModOperative = new ArrayList<ModalitaOperativa> ();
	}
	
	public boolean addModalitaOperativa(ModalitaOperativa modalitaOp)
	{
		if(listaModOperative.isEmpty())
		{
			listaModOperative.add(modalitaOp);
			return true;
		}
			
		else if(!modalitaGiaPresente(modalitaOp.getNomeModOperativa()))
		{
			listaModOperative.add(modalitaOp);
			return true;
		}
		return false;
		
	}
	
	
	public void setNomeCategoria(String nome)
	{
		super.setNomeCategoria(nome);
	}
	public String getNomeCategoria()
	{
		return super.getNomeCategoria();
	}
	
	
	public boolean removeModalitaOperativa(ModalitaOperativa modalitaOp)
	{
		if(modalitaGiaPresente(modalitaOp.getNomeModOperativa()))
		{
			listaModOperative.remove(modalitaOp);
			return true;
		}
		return false;
	}
	
	public boolean modalitaGiaPresente(String nomeModalita)
	{
		boolean presente = false;
		for(int i=0;i<listaModOperative.size();i++)
		{
			if(nomeModalita.equalsIgnoreCase(listaModOperative.get(i).getNomeModOperativa()))
			{
				presente = true;
			}
		}
		
		return presente;
	}
	
	public String[] stampaModalitaOperative()
	{
		String[] modalita= new String[listaModOperative.size()];
		
		for(int i=0; i<listaModOperative.size();i++)
		{
			modalita[i]= listaModOperative.get(i).getNomeModOperativa();
		}
		return modalita;
	}
	
	
	public ModalitaOperativa getModalitaOperative(int i)
	{
		return listaModOperative.get(i);
	}
	
	public int size()
	{
		return listaModOperative.size();
	}
}
