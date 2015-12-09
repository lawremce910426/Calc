package Function;

import java.util.ArrayList;

class FunctionSymbolDetecter {
	public FunctionSymbolDetecter(){}
	public int DetectSymbols(String func)
	{
		String Symbols = Erase(func ,"1234567980*/-+ ");
		ArrayList<String> Symbol = new ArrayList<String>();
		while(!Symbols.isEmpty())
		{
			Symbol.add(String.valueOf(Symbols.charAt(0)));
			Symbols = Erase(Symbols ,String.valueOf(Symbols.charAt(0)));
		}
		return Symbol.size();
	}
	
	String Erase(String data,String erase)
	{
		char[] eraseData = erase.toCharArray();
		for(int i = 0;i != data.length();i++)
			for(int j = 0;j != erase.length();j++)
				if(data.charAt(i) == eraseData[j])
				{
					data = data.substring(0 ,i) + data.substring(i + 1, data.length());
					i--;
				}
		return data;
	}
	
	public String GetSymbol(String Formula)
	{
		Formula = Erase(Formula, "132456789/*-+ ");
		return String.valueOf(Formula.charAt(0));
	}
	public char[] GetSymbols(String data)
	{
		data = Erase(data, "123456789/*-+ ");
		ArrayList<String> Symbol = new ArrayList<String>();
		while(!data.isEmpty())
		{
			Symbol.add(String.valueOf(data.charAt(0)));
			data = Erase(data ,String.valueOf(data.charAt(0)));
		}
		char[] ret = new char[Symbol.size()];
		for(int i = 0;i != Symbol.size();i++)ret[i] = ((String)Symbol.get(i)).charAt(0);
		return ret;
	}
}
