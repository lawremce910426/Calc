package Value;

class Reducer
{
	public Reducer(){}
	public LargeNumber gcd(LargeNumber a,LargeNumber b)
	{
		if(LargeNumber.Mod(a, b).Equals(new LargeNumber(0)))return b;
		if(LargeNumber.Mod(b, a).Equals(new LargeNumber(0)))return a;
		if(a.Bigger(b))a = LargeNumber.Mod(a, b);
		else b = LargeNumber.Mod(b, a);
		if(a.Equals(b))return a;
		else if(a.Smaller(b))return gcd(b ,a);
		else return gcd(a ,b);
	}
	public LargeNumber lcm(LargeNumber a,LargeNumber b)
	{
		return LargeNumber.Div(a.Mul(b), gcd(a ,b));
	}
	public Value Reduce(Value a) 
	{
		LargeNumber Demoninator = new LargeNumber(a.Denominator);
		LargeNumber Molecule = new LargeNumber(a.Molecule);
		a.Denominator = LargeNumber.Div(Demoninator, gcd(Demoninator ,Molecule));
		a.Molecule = LargeNumber.Div(Molecule, gcd(Demoninator ,Molecule));
		return new Value(a.Denominator ,a.Molecule);
	}
	
}