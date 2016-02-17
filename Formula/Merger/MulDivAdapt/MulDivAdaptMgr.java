package Merger.MulDivAdapt;


public class MulDivAdaptMgr {
	static int UsingTo = 0;//naming rule:adapt0 ,adapt1 ,adapt2
	public static String[] FirstItem(String data)
		//first one is the item.second one is the leftovers.third one is the idx to insert adapted.
	{
		int[] idx = FirstItemIdx(data);
		String [] ret = new String[3];
		ret[0] = data.substring(
				idx[0],
				idx[1]);
		ret[1] = data.substring(0 ,idx[0]) + data.substring(idx[1] ,data.length());
		ret[2] = String.valueOf(idx[0]);
		return ret;
	}
	static int[] FirstItemIdx(String data)//no brackets allowed
	{
		int[] ret = new int[2];ret[0] = -1;ret[1] = -1;
		for(int i = 0;i != data.length();i++)
		{
			if(data.charAt(i) == '*' || data.charAt(i) == '/')
			{
				int cpyI = i - 1;
				ret[0] = 0;
				while(cpyI-- != 0)
					if(data.charAt(cpyI) == '+' || data.charAt(cpyI) == '-'){ret[0] = cpyI + 2;break;}
				ret[1] = data.length();
				while(++i != data.length())
					if(data.charAt(i) == '+' || data.charAt(i) == '-'){ret[1] = i;break;}
				return ret;
			}
		}
		return ret;
	}
	
	public static MulDivAdaptTable GetTable(String before)
	{
		MulDivAdaptTable ret = new MulDivAdaptTable("adapted" + String.valueOf(UsingTo++) ,before);
		return ret;
	}
	public static String ToOriginal(String data ,MulDivAdaptTable[] keys)
	{
		UsingTo = 0;
		for(MulDivAdaptTable key : keys)
		{
			data.replace(key.adapted, key.beforeAdapt);
		}
		return data;
	}
}
