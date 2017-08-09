package LargeNumber;

class LargeNumber_CompareManager 
{
	public LargeNumber_CompareManager() {}
	boolean Big(LargeNumber n,LargeNumber Father)//is this bigger then n?(equal dont belong to a kind of bigger
	{
		if(Father.Equals(n))return false;
		if(Father.data.length > n.data.length)return true;
		if(Father.data.length < n.data.length)return false;
		for(int i = n.data.length - 1;i != -1;i--)
			if(Father.data[i].Get() > n.data[i].Get())
				return true;
			else
				if(Father.data[i].Get() != n.data[i].Get())return false;
		return false;
		
	}
	boolean Small(LargeNumber n,LargeNumber Father)//is this smaller then n?(equal dont belong to a kind of smaller
	{
		if(Father.Equals(n))return false;
		if(Father.data.length < n.data.length)return true;
		if(Father.data.length > n.data.length)return false;
		for(int i = n.data.length - 1;i != -1;i--)
			if(Father.data[i].Get() > n.data[i].Get())
				return false;
			else
				if(Father.data[i].Get() != n.data[i].Get())return true;
		return true;
	}
	boolean Equal(LargeNumber n,LargeNumber Father)
	{
		if(Father.data.length != n.data.length)return false;
		for(int i = 0;i != Father.data.length;i++)if(Father.data[i].Get() != n.data[i].Get())return false;
		return true;
	}
}