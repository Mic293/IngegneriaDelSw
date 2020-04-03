package versione_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InfoRilevabile implements Serializable{

	private String tipoInfoRilevabile; //dominio
	private Map<String, Integer> listaMisurazioni;
	
	public InfoRilevabile(String _tipoInfoRilevabile)
	{
		this.tipoInfoRilevabile= _tipoInfoRilevabile;
		listaMisurazioni= new HashMap<String, Integer>();
	}
	
	public void setTipoInfoRilevabile(String _tipoInfoRilevabile)
	{
		this.tipoInfoRilevabile=_tipoInfoRilevabile;
	}
	
	public String getTipoInfoRilevabile()
	{
		return tipoInfoRilevabile;
	}
	
	public void addMisurazione(String nomeSensore, Integer misuraSensore)
	{
			listaMisurazioni.put(nomeSensore, misuraSensore);
	}
	
	public int size()
	{
		return listaMisurazioni.size();
	}
	
	public Map<String, Integer> getListaMisurazioni()
	{
		return listaMisurazioni;
	}
	
	
}
