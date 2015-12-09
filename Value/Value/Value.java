package Value;

public class Value{
	public LargeNumber Denominator;//the one down
	public LargeNumber Molecule;//the one up
	Reducer reducer;
	ValueReducer MultiThreadReducer;
	//-----------------------------multithread lock---------------------------
	boolean Running;
	boolean Reducing;
	//------------------------------------------------------------------------
	public boolean Reduced = true;
	//-----------------------------is thrown----------------------------------
	boolean notthrown = true;
	//------------------------------------------------------------------------
	public Value(String number)
	{
		Thread t = new ValueReducer(this);
		t.start();
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
		reducer = new Reducer();Denominator = new LargeNumber(a.Denominator);Molecule = new LargeNumber(a.Molecule);
	}
	public Value(LargeNumber demoninator,LargeNumber molecule)
	{
		Denominator = new LargeNumber(demoninator);
		Molecule = new LargeNumber(molecule);
	}
	
	public void Reduce()
	{
		Value eax = reducer.Reduce(this);
		Denominator = eax.Denominator;
		Molecule = eax.Molecule;
	}
	
	public Value ADD(Value a)
	{
		while(Reducing){}
		Running = true;
		LargeNumber Molecule_cpy = new LargeNumber(Molecule);
		Molecule = Molecule.Mul(a.Molecule);
		Denominator = Denominator.Mul(a.Molecule);
		a.Denominator = a.Denominator.Mul(Molecule_cpy);
		Denominator.Add(a.Denominator);
		Running = false;
		Reduced = false;
		return this;
	}
	public Value SUB(Value a)//this - a.
	{
		while(Reducing){}
		Running = true;
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
		Running = false;
		Reduced = false;
		return this;
	}
	public Value MUL(Value a)
	{
		while(Reducing){}
		Running = true;
		Denominator = Denominator.Mul(a.Denominator);
		Molecule = Molecule.Mul(a.Molecule);
		Running = false;
		Reduced = false;
		return this;
	}
	public Value DIV(Value a)//this / a.Decimal and leftovers would still be stored.
	{
		while(Reducing){}
		Running = true;
		Denominator = Denominator.Mul(a.Molecule);
		Molecule = Molecule.Mul(a.Denominator);
		Running = false;
		Reduced = false;
		return this;
	}
	public boolean Equals(Value a)
	{
		Reduce();
		a.Reduce();
		return (a.Denominator == Denominator && a.Molecule == Molecule ? true : false);
	}
	public int toInt()
	{
		return Denominator.toInt() / Molecule.toInt();
	}
	@Override
	public String toString()
	{
		while(!Reduced){}
		return Denominator.toString() + " / " + Molecule.toString();
	}
}
