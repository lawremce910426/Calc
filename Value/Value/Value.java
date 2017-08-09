package Value;

import LargeNumber.LargeNumber;

public class Value{
	public LargeNumber Denominator;//the one down
	public LargeNumber Molecule;//the one up
	Reducer reducer;
	public boolean Positive = true;
	PositiveManager positiveMgr;
	
	public Value(String number)
	{
		positiveMgr = new PositiveManager();
		reducer = new Reducer();
		int commaIndex = number.indexOf(".");
		if(commaIndex == -1)
		{
			Molecule = new LargeNumber(1);
		}
		else
		{
			Molecule = LargeNumber.Square(new LargeNumber(10) ,new LargeNumber(number.length() - commaIndex - 1));
		}
		Denominator = new LargeNumber(number.replace(".", ""));
	}
	public Value(Value a)
	{
		positiveMgr = new PositiveManager();
		Positive = a.Positive;
		reducer = new Reducer();
		Denominator = new LargeNumber(a.Denominator);
		Molecule = new LargeNumber(a.Molecule);
	}
	public Value(LargeNumber demoninator,LargeNumber molecule)
	{
		positiveMgr = new PositiveManager();
		Denominator = new LargeNumber(demoninator);
		Molecule = new LargeNumber(molecule);
	}
	
	public void NotForceReduce()
	{
		if(this.Denominator.Bigger(new LargeNumber(100)) || this.Molecule.Bigger(new LargeNumber(100)))
		{
			Value eax = reducer.Reduce(this);
			Denominator = eax.Denominator;
			Molecule = eax.Molecule;
		}
	}
	public void ForceReduce()
	{
		Value eax = reducer.Reduce(this);
		Denominator = eax.Denominator;
		Molecule = eax.Molecule;
	}
	
	public Value ADD(Value a)
	{
		return positiveMgr.ADD(this, a);
	}
	public Value SUB(Value a)
	{
		return positiveMgr.SUB(this ,a);
	}
	public Value MUL(Value a)
	{
		return positiveMgr.MUL(this, a);
	}
	public Value DIV(Value a)
	{
		return positiveMgr.DIV(this ,a);
	}
	
	
	
	public Value Add(Value a)
	{
		LargeNumber Molecule_cpy = new LargeNumber(Molecule);
		Molecule = Molecule.Mul(a.Molecule);
		Denominator = Denominator.Mul(a.Molecule);
		a.Denominator = a.Denominator.Mul(Molecule_cpy);
		Denominator.Add(a.Denominator);
		NotForceReduce();
		return this;
	}
	public Value Sub(Value a)//this - a.
	{
		if(a.Equals(this)){
			Denominator = new LargeNumber(0);
			Molecule = new LargeNumber(1);
			return this;
		}
		LargeNumber Molecule_cpy = new LargeNumber(Molecule);
		Molecule = Molecule.Mul(a.Molecule);
		Denominator = Denominator.Mul(a.Molecule);
		a.Denominator = a.Denominator.Mul(Molecule_cpy);
		Denominator.Sub(a.Denominator);
		NotForceReduce();
		return this;
	}
	public Value Mul(Value a)
	{
		Denominator = Denominator.Mul(a.Denominator);
		Molecule = Molecule.Mul(a.Molecule);
		NotForceReduce();
		return this;
	}
	public Value Div(Value a)//this / a.Decimal and leftovers would still be stored.
	{
		Denominator = Denominator.Mul(a.Molecule);
		Molecule = Molecule.Mul(a.Denominator);
		NotForceReduce();
		return this;
	}
	
	
	
	
	public boolean Bigger(Value a)
	{
		LargeNumber thisBuf = new LargeNumber(this.Denominator);
		LargeNumber aBuf = new LargeNumber(a.Denominator);
		thisBuf = thisBuf.Mul(a.Molecule);
		aBuf = aBuf.Mul(Molecule);
		if(thisBuf.Equals(aBuf))return false;
		return thisBuf.Bigger(aBuf);
	}
	public boolean Smaller(Value a)
	{
		if(a.Equals(this))return false;
		return !Bigger(a);
	}
	public boolean Equals(Value a)
	{
		ForceReduce();
		a.ForceReduce();
		return (a.Denominator == Denominator && a.Molecule == Molecule ? true : false);
	}
	public int toInt()
	{
		NotForceReduce();
		return Denominator.toInt() / Molecule.toInt();
	}
	@Override
	public String toString()
	{
		ForceReduce();
		return (Positive ? "" : "- ") + Denominator.toString() + " / " + Molecule.toString();
	}
}
