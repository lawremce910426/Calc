package Merger;

import ResolveCommand.ResolveCommand;

public class DistributiveMul
{
	public DistributiveMul()
	{	}
	public String OneToMul(String Input)
	{
		Pair[] pair = ToPairs(Input);
		int[] idx = ResolveCommand.GetPairIndex(Input); 
		String FirstItem = Input.substring(0, idx[0] - 3);
		char FirstSymbol = Input.substring(idx[0] - 2).charAt(0);
		DistributiveTwo distriMgr = new DistributiveTwo();
		String ret = distriMgr.OpenBracketTwo(FirstItem + " " + FirstSymbol + " ("
				+ pair[0].data + " " + pair[1].symbol + " " + pair[1].data + ")");
		if(pair.length == 2)return ret;
		for(int i = 2;i < pair.length;i+=2)
			if(pair.length % 2 != 0)
				if(i == pair.length - 1)//last item, add it yourself
					ret += " " + pair[i].symbol + " " + FirstItem + " " + FirstSymbol + " " + pair[i].data;
				else
					ret += " " + pair[i].symbol + " " + distriMgr.OpenBracketTwo(FirstItem + " " + FirstSymbol + " ("
							+ pair[i].data + " " + pair[i + 1].symbol + " " + pair[i + 1].data + ")");
			else 
				ret += " " + pair[i].symbol + " " + distriMgr.OpenBracketTwo(FirstItem + " " + FirstSymbol + " ("
						+ pair[i].data + " " + pair[i + 1].symbol + " " + pair[i + 1].data + ")");
		return ret;
	}
	
	public String MulToMul(String Input)
	{
		Pair[] pair = ToPairs(Input);//only the first bracket.
		int[] idx = ResolveCommand.GetPairIndex(Input); //only detect the first bracket
		char symbol = Input.substring(idx[1] + 2 ,idx[1] + 3).charAt(0);
		String data = Input.substring(idx[1] + 4);
		String ret = OneToMul(pair[0].data + " " + symbol + " " + data);
		for(int i = 1;i != pair.length;i++)
					ret += " " + pair[i].symbol + " " + OneToMul(pair[i].data + " " + symbol 
							+ " " + data);
		return ret;
	}
	/*public String MultipleBracket(String input)
	{
		
	}*/
	Pair[] ToPairs(String Input)
	{
		int[] idx = ResolveCommand.GetPairIndex(Input); 
		String InsideData = Input.substring(idx[0] + 1, idx[1]);
		int Pairs = InsideData.split(" ").length / 2 + 1;
		char[] symbols = new char[Pairs];symbols[0] = '+';
		String[] Data = new String[Pairs];
		Data[0] = InsideData.split(" ")[0];
		//-----------------´î±¼data[0]--------------------
		while(InsideData.charAt(0) != ' ')InsideData = InsideData.substring(1);
		InsideData = InsideData.substring(1);
		int on = 1;
		//-----------------------------------------------
		while(!InsideData.equals(""))
		{
			symbols[on] = InsideData.charAt(0);
			InsideData = InsideData.substring(2);//and the space
			Data[on] = "";//¶¶«Kinit
			while(!(InsideData.length() == 0 || InsideData.charAt(0) == ' '))
			{
				Data[on] += InsideData.charAt(0);
				InsideData = InsideData.substring(1);
			}
			if(InsideData.length() != 0)InsideData = InsideData.substring(1);
			on++;
		}
		Pair[] pairs = new Pair[symbols.length];
		for(int i = 0;i != symbols.length;i++)pairs[i] = new Pair(symbols[i] ,Data[i]);
		return pairs;
	}
}

