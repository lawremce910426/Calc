package Value;

public class LargeNumber
{
	Number_10[] data;
	LargeNumber_AddManager AddMgr;
	LargeNumber_SubManager SubMgr;
	LargeNumber_CompareManager CmpMgr;
	public LargeNumber(LargeNumber n)
	{
		AddMgr = new LargeNumber_AddManager();
		CmpMgr = new LargeNumber_CompareManager();
		SubMgr = new LargeNumber_SubManager(this);
		data = new Number_10[n.data.length];
		for(int i = 0;i != n.data.length;i++)data[i] = n.data[i].clone();
	}
	public LargeNumber(int num)
	{
		AddMgr = new LargeNumber_AddManager();
		CmpMgr = new LargeNumber_CompareManager();
		SubMgr = new LargeNumber_SubManager(this);
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
		AddMgr = new LargeNumber_AddManager();
		CmpMgr = new LargeNumber_CompareManager();
		SubMgr = new LargeNumber_SubManager(this);
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
	
	public LargeNumber Mul(LargeNumber n)
	{
		LargeNumber Big = new LargeNumber(0);
			Big = new LargeNumber(Bigger(n) ? n : this);
		LargeNumber Small = new LargeNumber(0);
			Small = new LargeNumber(Bigger(n) ? this : n);
		LargeNumber FirstNum = new LargeNumber(0);
			FirstNum = new LargeNumber(Big);
		Big = new LargeNumber(0);
		while(!Small.Equals(new LargeNumber(0)))
		{
			Small.Sub(new LargeNumber(1));
			Big.Add(FirstNum);
		}
		return Big;
	}
	 
	public static LargeNumber Div(LargeNumber a ,LargeNumber b)//a / b , decimal and leftovers will be ignored.
	{
		LargeNumber test = new LargeNumber(0);
		LargeNumber times = new LargeNumber(0);
		while(a.Bigger(test))
		{
			test.Add(b);
			times.Add(new LargeNumber(1));
		}
		if(!a.Equals(test))times.Sub(new LargeNumber(1));
		return times;
	}
	
	public static LargeNumber Mod(LargeNumber a,LargeNumber b)//a % b
	{
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
}
