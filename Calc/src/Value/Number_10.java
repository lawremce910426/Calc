package Value;

class Number_10 implements Cloneable
{
	boolean[] data;
	public Number_10(int num) throws Exception//num can only be number between 0~9
	{
		data = new boolean[4];
		if(num < 0 || num > 9)
			throw new Exception("num should only be 0~9");
		for(int i = 3;i >= 0;i--)
		{
			if((int)Math.pow(2, i) <= num)
			{
				num -= (int)Math.pow(2, i);
				data[i] = true;
			}
			else
			{
				data[i] = false;
			}
		}
	}
	
	@Override
	public Number_10 clone()
	{
		try {
			return new Number_10(this.Get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Number_10 Add(Number_10 number) throws Exception
	{
		Number_10 copy = this.clone();
  		for(int i = 0;i != 4;i++)
		{
			try{
				data[i] = Addition(number.data[i] ,data[i]);
			}
			catch(Exception e)
			{
				if(e.getMessage() == "Carry")
				{
					data[i] = false;
					if(i + 1 == 4){this.data = copy.data;throw new Exception("Needs Carry");}
					try{  Carry(i + 1);  }
					catch(Exception ex)
					{
						this.data = copy.data;throw new Exception("Needs Carry");
					}
				}
			}
			if(IsOver10(this)){this.data = copy.data;throw new Exception("Needs Carry");}
		}
		return this;
	}
	boolean IsOver10(Number_10 num)
	{
		try {
			if(Bigger(num ,new Number_10(9)))
					return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	boolean Addition(boolean a,boolean b) throws Exception 
	{
		if(a && b){throw new Exception("Carry");}
		if(!a && b)return true;
		if(a && !b)return true;
		if(!a && !b)return false;
		throw new Exception("Unreachable code");
	}
	void Carry(int Index) throws Exception
	{
		try{
			data[Index] = Addition(data[Index] ,true);
		}catch(Exception e)
		{
			data[Index] = false;
			if(Index == 3)throw new Exception("Needs Carry");
			if(e.getMessage() == "Carry")
			{
				Carry(++Index);
			}
		}
	}
	
	
	public static boolean Bigger(Number_10 a,Number_10 b) throws Exception//a bigger then b
	{
		if(Equals(a ,b))throw new Exception("Equals");
		if(a.Get() > b.Get())return true;
		else return false;
	} 
	public static boolean Smaller(Number_10 a,Number_10 b) throws Exception//a smaller then b
	{
		return Bigger(b ,a);
	}
	public static boolean Equals(Number_10 a,Number_10 b)
	{
		for(int i = 0;i != 4;i++)
			if(a.data[i] != b.data[i])return false;
		return true;
	}
	
	
	
	
	
	public Number_10 Sub(Number_10 number) throws Exception//this - number
	{
		
		if(Equals(this ,number))
		{
			for(int i = 0;i != 4;i++)
				data[i] = false;
			return this;
		}
		try
		{
			if(Smaller(this ,number))throw new Exception("this is smaller then number");
		}
		catch(Exception e)
		{
			if(e.getMessage() == "this is smaller then number")throw e;
		}
		
		for(int i = 3;i != -1;i--)
		{
			try
			{
				data[i] = Subtraction(data[i] ,number.data[i]);
			}
			catch(Exception e)
			{
				Borrow(i + 1);
				data[i] = true;
			}
		}
		return this;
	}
	boolean Subtraction(boolean a,boolean b) throws Exception//a - b
	{
		if(!a && b)throw new Exception("Borrow");
		if(a && b)return false;
		if(a && !b)return true;
		if(!a && !b)return false;
		throw new Exception("Unreachable code");
	}
	void Borrow(int Index) throws Exception
	{
		try
		{
			data[Index] = Subtraction(data[Index], true);
		}
		catch(Exception e)
		{
			if(Index == 3)throw new Exception("Needs Borrow");
			Borrow(Index + 1);
			data[Index] = true;
		}
	}
	
	public int Get()
	{
		int result = 0;
		for(int i = 0;i != 4;i++)
			result += (data[i] ? Math.pow(2, i) : 0);
		return result;
	}
	
}