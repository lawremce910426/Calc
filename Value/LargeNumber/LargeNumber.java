package LargeNumber;

import Value.Number_10;

public class LargeNumber
{
	Number_10[] data;
	LargeNumber_AddManager AddMgr;
	LargeNumber_SubManager SubMgr;
	LargeNumber_MulManager MulMgr;
	LargeNumber_DivManager DivMgr;
	LargeNumber_CompareManager CmpMgr;
	public LargeNumber(LargeNumber n)
	{
		Init();
		data = new Number_10[n.data.length];
		for(int i = 0;i != n.data.length;i++)data[i] = n.data[i].clone();
	}
	public LargeNumber(int num)
	{
		Init();
		data = new Number_10[GetDigit(num)];
		if(num == 0)
		{
			data = new Number_10[1];
			try {
				data[0] = new Number_10(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
			for(int i = GetDigit(num) - 1;i != -1;i--)
			{
				int Times = 0;
				while(num >= Math.pow(10, i))
				{
					num -= Math.pow(10, i);Times++;
				}
				try {
					data[i] = new Number_10(Times);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
	}
	public LargeNumber(String num)
	{
		Init();
		data = new Number_10[num.toCharArray().length];
		char[] numArr = num.toCharArray();
		for(int i = 0;i != data.length;i++)
		{
			try {
				data[data.length - 1 - i] = new Number_10((int)Integer.valueOf(numArr[i] + ""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public LargeNumber(Number_10[] newData) {
		Init();
		data = newData.clone();
	}
	void Init()
	{
		AddMgr = new LargeNumber_AddManager();
		CmpMgr = new LargeNumber_CompareManager();
		SubMgr = new LargeNumber_SubManager(this);
		MulMgr = new LargeNumber_MulManager();
		DivMgr = new LargeNumber_DivManager();
	}

	int GetDigit(int n)
	{
		for(int i = 0;;i++)
			if(n < Math.pow(10,  i))
				return i - 1 + 1;
	}
	
 	public boolean Bigger(LargeNumber n){return CmpMgr.Big(n ,this); }
	public boolean Smaller(LargeNumber n){return CmpMgr.Small(n ,this); }
	public boolean Equals(LargeNumber n){return CmpMgr.Equal(n ,this); }
	
	public void Add(LargeNumber n){this.data = (AddMgr.Add(n ,this)).data;}
	
	public void Sub(LargeNumber n){SubMgr.Sub(n);}
	
	public LargeNumber Mul(LargeNumber n){return MulMgr.Multiple(this, n);}
	 
	public LargeNumber Div(LargeNumber a ,LargeNumber b)//a / b , decimal and leftovers will be ignored.
	{	return DivMgr.Divide(a ,b);	}
	
	public LargeNumber Mod(LargeNumber a,LargeNumber b)//a % b
	{
		if(a.Smaller(b)) return new LargeNumber(a);
		if(a.Equals(b)) return new LargeNumber(0);
		
		LargeNumber eax = Div(a, b);
		LargeNumber ebx = new LargeNumber(a);
		ebx.Sub(eax.Mul(b));
		return ebx;
	}
	public static LargeNumber Square(LargeNumber a,LargeNumber b)//a ^ b
	{
		LargeNumber clone = new LargeNumber(0);
		clone = new LargeNumber(a);
		while(!b.Equals(new LargeNumber(1)))
		{
			b.Sub(new LargeNumber(1));
			a = a.Mul(clone);
		}
		return a;
	}
	
	public LargeNumber AddZeros(LargeNumber a ,int HowMuch)
	{
		LargeNumber ret = new LargeNumber(a);
		try {
			for(int i = 0;i != HowMuch;i++)
				ret = TimesTen(ret);
		} catch (Exception e) {
			e.printStackTrace();	//impossible code. unless out of memory.
		}
		return ret;
	}
	
	public LargeNumber TimesTen(LargeNumber a) throws Exception
	{
		Number_10[] data = a.data;
		Number_10[] NewData = new Number_10[data.length + 1];
		NewData[0] = new Number_10(0);
		for(int i = 1;i != NewData.length;i++)
			NewData[i] = data[i - 1].clone();
		return new LargeNumber(NewData);
	}

	public int toInt()
	{
		int eax = 0;
		eax = Integer.valueOf(toString());
		return eax;
	}
	public String toString()
	{
		String eax = "";
		for(int i = data.length - 1;i != -1;i--)
		{
			eax += String.valueOf(data[i].Get());
		}
		return eax;
	}
	
	public void CleanUpJunk()
	{
		int RealLength = data.length;
		for(int i = data.length - 1;i != -1 ;i--)
		{
			if(data[i].Get() == 0)RealLength--;
			else break;
		}
		
		Number_10[] useful_data = new Number_10[RealLength];
		for(int i = 0;i != useful_data.length;i++)
			useful_data[i] = data[i];
		data = useful_data.clone();
	}
}
