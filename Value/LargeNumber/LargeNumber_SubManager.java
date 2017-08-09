package LargeNumber;

import Value.Number_10;

class LargeNumber_SubManager
{
	LargeNumber Father;
	public LargeNumber_SubManager(LargeNumber father){Father = father;}
	
	public void Sub(LargeNumber n)//this will be the absolute value of (this - n).
	{
		if(Father.Equals(n))
		{
			Father.data = new Number_10[1];
			try {Father.data[0] = new Number_10(0);} catch (Exception e) {e.printStackTrace();}
			return;
		}
		LargeNumber Big = (Father.Bigger(n) ? Father : n).Mul(new LargeNumber(1));
		LargeNumber Small = (Father.Bigger(n) ? n : Father).Mul(new LargeNumber(1));
		for(int i = 0;i != Small.data.length;i++)
		{
				try {
					Big.data[i].Sub(Small.data[i]);
				} catch (Exception e) {
					Borrow(Big ,i + 1);
					try {
						Big.data[i] = new Number_10(9).Sub(Small.data[i].Sub(new Number_10(1))).Add(Big.data[i]);
						//9 - (x - 1) = 10 -x
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
		}
		//------------clean the useless data---------------------
		try {
			while(Number_10.Equals(Big.data[Big.data.length - 1], new Number_10(0)) && !(Big.data.length == 1))	
				DeleteLast(Big);
		} catch (Exception e) {//unreachable code
			e.printStackTrace();
		} 
		Father.data = Big.data;
	}
	
	void Borrow(LargeNumber n ,int Index)
	{
		try {
			n.data[Index].Sub(new Number_10(1));
		} catch (Exception e) {
			Borrow(n ,Index + 1);
			try {
				n.data[Index] = new Number_10(9);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	void DeleteLast(LargeNumber n)
	{
		Number_10[] clone = new Number_10[n.data.length - 1];
		for(int i = 0;i != n.data.length - 1;i++){
			clone[i] = n.data[i];
		}
		n.data = clone;
	}
}