package versione_1;


public class Sensore extends UnitaRilevazione{

	
	private Double valoreRilevato;
		
	public Sensore(String nome) {
		super(nome);
	}
	public Sensore()
	{
		
	}
	
	public void setValoreRilevato(Double _valoreRilevato)
	{
		this.valoreRilevato= _valoreRilevato;
	}
	
	public Double getValoreRilevato()
	{
		return valoreRilevato;
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
	public CategoriaSensori getCategoria()
	{
		return (CategoriaSensori)super.getCategoria();
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
