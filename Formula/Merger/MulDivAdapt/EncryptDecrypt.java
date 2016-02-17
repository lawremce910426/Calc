package Merger.MulDivAdapt;
import java.util.ArrayList;

import Merger.MulDivAdapt.MulDivAdaptMgr;
import Merger.MulDivAdapt.MulDivAdaptTable;

public class EncryptDecrypt {
	static KeyAndString EncryptSingle(String data)
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
		return new KeyAndString(keys.get(0) , data);
	}
	public static KeysAndString Encrypt(String data)
	{
		KeysAndString ret = 
				new KeysAndString(new java.util.ArrayList<MulDivAdaptTable>() ,"");
		try
		{
			while(true)
			{
				KeyAndString result = EncryptSingle(data);
				data = result.data;
				ret.data = data;
				ret.Keys.add(result.key);
			}
		}catch(Exception e){return ret;}
	}
	static String DecryptSingle(KeyAndString data)
	{
		data.data.replace(data.key.adapted, data.key.beforeAdapt);
		return data.data;
	}
	public static String Decrypt(KeysAndString data)
	{
		String ret = data.data;
		for(MulDivAdaptTable key : data.Keys)
			ret = DecryptSingle(new KeyAndString(key ,ret));
		return ret;
	}
}
