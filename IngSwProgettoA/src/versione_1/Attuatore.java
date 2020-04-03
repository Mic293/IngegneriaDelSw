package versione_1;


public class Attuatore extends UnitaRilevazione{

	private ModalitaOperativa modOperativa;
	
	public Attuatore(String nome, ModalitaOperativa modOperativa) {
		super(nome);
		this.modOperativa = modOperativa;
	}
	public Attuatore()
	{
		
	}
	public void setModOperativa(ModalitaOperativa _modOperativa)
	{
		modOperativa= _modOperativa;
	}
	
	public ModalitaOperativa getModOperativa()
	{
		return modOperativa;
	}
	
	public void setNomeUnita(String nome)
	{
		super.setNomeUnita(nome);
	}
	public String getNomeUnita()
	{
		return super.getNomeUnita();
	}
	public void setCategoria(Categoria categoria)
	{
		super.setCategoria(categoria);
	}
	public CategoriaAttuatori getCategoria()
	{
		return (CategoriaAttuatori)super.getCategoria();
	}
	public void setUnitaDomotica(UnitaDomotica unita)
	{
		super.setUnitaDomotica(unita);
	}
	public UnitaDomotica getUnitaDomotica()
	{
		return super.getUnitaDomotica();
	}
	public Stato getStato()
	{
		return super.getStato();
	}
}
