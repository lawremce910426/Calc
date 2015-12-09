package Function;

import Value.Value;

public class Function {
	FunctionSymbolDetecter detector;
	MultipleFunction multi;
	SingleFunction single;
	public boolean issingle = false;
	public char[] UnknownList;
	public Function(String data)
	{
		detector = new FunctionSymbolDetecter();
		if(detector.DetectSymbols(data) == 1)
			try {
				single = new SingleFunction(data);
				issingle = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		else
			try {
				multi = new MultipleFunction(data);
				issingle = false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		UnknownList = detector.GetSymbols((issingle ? single.formula : multi.data));
	}
	public Value PutIn(Value value) throws Exception
	{
		if(issingle == false)throw new Exception("this is not a single function");
		return single.PutIn(value);
	}
	public Value PutIn(Value[] value) throws Exception//用字母的字典順序(a, b, c)來當作KEY ex. x = value[0] y = value[1](在只有x ,y
	{
		 if(issingle == true)throw new Exception("this is not a multiple funciton");
		 return multi.PutIn(value);
	}
}
