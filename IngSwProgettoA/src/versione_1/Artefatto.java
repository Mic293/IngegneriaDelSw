package versione_1;


public class Artefatto extends UnitaDomotica{

	private String stanza;
	
	public Artefatto(String unitName)
	{
		super(unitName);
	}
	
	public void setStanza(String _stanza)
	{
		stanza=_stanza;
	}
	
	public String getStanza()
	{
		return stanza;
	}
}
