package Merger;

import java.util.ArrayList;

public class Distributive
{
	
	public Distributive()
	{	}
	public String DoDistributive(String data)
	{
		ArrayList<MulDivAdaptTable> keys = new ArrayList<MulDivAdaptTable>();
		String[] results = MulDivAdaptMgr.FirstItem(data);
		keys.add(MulDivAdaptMgr.GetTable(results[0]));
		StringBuffer newData = new StringBuffer();
		newData.append(results[1]);
		if(Integer.valueOf(results[2]) == results[1].length())
			newData.insert(Integer.valueOf(results[2]), keys.get(0).adapted);
		else
			newData.insert(Integer.valueOf(results[2]), keys.get(0).adapted + " ");
		data = newData.toString();
		return data;
	}
}




