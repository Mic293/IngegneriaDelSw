package versione_1;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class UnitaDomotica implements Serializable{
	

	private String unitName;
	
	public UnitaDomotica(String unitName)
	{
		this.unitName = unitName;
	}
	
	public UnitaDomotica()
	{
		
	}
	
	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}
	
	public String getUnitName()
	{
		return unitName;
	}
	
		
}
