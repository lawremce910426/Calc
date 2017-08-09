package LargeNumber;

import Value.Number_10;

class LargeNumber_MulManager 
{
	static MultiTable Table;
	public LargeNumber Multiple(LargeNumber a,LargeNumber b)
	{
		Table = new MultiTable();

		LargeNumber result = new LargeNumber(0);
		
		for(int i = 0;i != a.data.length;i++)
			for(int j = 0;j != b.data.length;j++)
			{
				LargeNumber First = Table.GetResult(a.data[i], b.data[j]);
				First = First.AddZeros(First, i + j);
				result.Add(First);
			}
		return result;
	}
	

	
}

class MultiTable	//0~9 instead of 2~9
{
	static int[][] data;
	static boolean HadInited = false;
	
	public MultiTable()
	{
		if(!HadInited)
		{
			data = new int[10][10];
			
			for(int i = 0;i != 10;i++)
				for(int j = 0;j != 10;j++)
					data[i][j] = i * j;
		}
	}
	
	public LargeNumber GetResult(Number_10 _1 ,Number_10 _2) 
	{
		return new LargeNumber(data[_1.Get()][_2.Get()]);
	}
	
}
