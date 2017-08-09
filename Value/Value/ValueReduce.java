package Value;

import LargeNumber.LargeNumber;

class Reducer
{
	public Reducer(){}
	public LargeNumber gcd(LargeNumber a,LargeNumber b)
	{
		LargeNumber calc = new LargeNumber(0);
		
		if(calc.Mod(a, b).Equals(new LargeNumber(0)))return b;
		if(calc.Mod(b, a).Equals(new LargeNumber(0)))return a;
		if(a.Bigger(b))a = calc.Mod(a, b);
		else b = calc.Mod(b, a);
		if(a.Equals(b))return a;
		else if(a.Smaller(b))return gcd(b ,a);
		else return gcd(a ,b);
	}
	public LargeNumber lcm(LargeNumber a,LargeNumber b)
	{
		LargeNumber calc = new LargeNumber(0);
		return calc.Div(a.Mul(b), gcd(a ,b));
	}
	public Value Reduce(Value a) 
	{
		LargeNumber calc = new LargeNumber(0);
		
		LargeNumber Demoninator = new LargeNumber(a.Denominator);
		LargeNumber Molecule = new LargeNumber(a.Molecule);
		a.Denominator = calc.Div(Demoninator, gcd(Demoninator ,Molecule));
		a.Molecule = calc.Div(Molecule, gcd(Demoninator ,Molecule));
		return new Value(a.Denominator ,a.Molecule);
	}
	
}