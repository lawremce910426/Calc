package Value;

class PositiveManager {
	public PositiveManager()
	{	}
	public Value ADD(Value a,Value b)
	{
		if(a.Positive && b.Positive){
			a = a.Add(b);
			return a;
		}
		if(!a.Positive && b.Positive){
			a.Positive = true;
			a = SUB(b ,a);
			a.Positive = false;
			return a;
		}
		if(a.Positive && !b.Positive){
			a.Positive = true;
			a = SUB(a ,b);
			a.Positive = false;
			return a;
		}
		if(!a.Positive && !b.Positive){
			a = a.Add(b);
			return a;
		}
		return null;
	}
	public Value SUB(Value a,Value b)
	{
		if(a.Positive && b.Positive)
			if(a.Bigger(b))
			{
				a = a.Sub(b);
				return a;
			}
			else
			{
				a = b.Sub(a);
				a.Positive = false;
				return a;
			}
		if(!a.Positive && b.Positive)
		{
			a = a.Add(b);
			return a;
		}
		if(a.Positive && !b.Positive)
			return a.Add(b);
		if(!a.Positive && !b.Positive)
			if(b.Bigger(a))
			{
				a = b.Sub(a);
				return a;
			}
			else
			{
				a.Positive = false;
				a = a.Sub(b);
				return a;
			}
		return null;
	}
	public Value MUL(Value a,Value b)
	{
		if(a.Positive && b.Positive)
		{
			a = a.Mul(b);
			return a;
		}
		if(!a.Positive && b.Positive)
		{
			a.Positive = false;
			a = a.Mul(b);
			return a;
		}
		if(a.Positive && !b.Positive)
		{
			a.Positive = false;
			a = a.Mul(b);
			return a;
		}
		if(!a.Positive && !b.Positive)
		{
			a.Positive = true;
			a = a.Mul(b);
			return a;
		}
		return null;
	}
	public Value DIV(Value a,Value b)
	{
		if(a.Positive && b.Positive)
		{
			a = a.Div(b);
			return a;
		}
		if(!a.Positive && b.Positive)
		{
			a.Positive = false;
			a = a.Div(b);
			return a;
		}
		if(a.Positive && !b.Positive)
		{
			a.Positive = false;
			a = a.Div(b);
			return a;
		}
		if(!a.Positive && !b.Positive)
		{
			a.Positive = true;
			a = a.Div(b);
			return a;
		}
		return null;
	}
}
