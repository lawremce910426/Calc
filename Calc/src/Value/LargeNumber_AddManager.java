package Value;

class LargeNumber_AddManager
{
	public LargeNumber_AddManager() {}
	public LargeNumber Add(LargeNumber n, LargeNumber Father)
	{
  		LargeNumber BeAdd = new LargeNumber(Father.Bigger(n) ? Father : n);
 		LargeNumber Adder = new LargeNumber(Father.Smaller(n) ? Father : n);
		for(int i = 0;i != Adder.data.length;i++)
		{
			try {
				BeAdd.data[i].Add(Adder.data[i]);
			} catch (Exception e) {
				try {
					BeAdd.data[i] = new Number_10(BeAdd.data[i].Get() + Adder.data[i].Get() - 10);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
				Carry(BeAdd ,i + 1);
			}
		}
		return BeAdd;
	}
	void Carry(LargeNumber n ,int Index)
	{
		while(n.data.length <= Index)AddSize(n);
		try {
			n.data[Index].Add(new Number_10(1));
		} catch (Exception e) {
			try {
				n.data[Index] = new Number_10(n.data[Index].Get() + 1 - 10);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			Carry(n ,Index + 1);
		}
	}
	LargeNumber AddSize(LargeNumber n)
	{
		Number_10[] eax = new Number_10[n.data.length + 1];
		try {
			eax[eax.length - 1] = new Number_10(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0;i != eax.length - 1;i++)eax[i] = n.data[i];
		n.data = eax;
		return n;
	}
	
}