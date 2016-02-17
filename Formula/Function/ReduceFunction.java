package Function;

import NumberCalculating.NumberCalculating;
import Value.Value;

class ReduceFunction {
	NumberCalculating calc;
	FunctionSymbolDetecter detector;
	public ReduceFunction(){calc = new NumberCalculating();}
	public String Reduce(String func)
	{
		
	}
	String ReduceBracket(String func)
	{
		int idx[] = ResolveCommand.ResolveCommand.GetPairIndex(func);
		if(idx[0] == -1|| idx[1] == -1)
		{
			return func;
		}
		else
		{
			while(!(idx[0] == -1|| idx[1] == -1))
			{
				String BracketFunction = func.substring(idx[0] ,idx[1] - 1);
				func = func.substring(0 ,idx[0] - 1) + func.substring(idx[1] ,func.length());
				//----------------------------ex. (12 + 3 + x) * x---------------
				//----------BracketFunction: (12 + 3 + x) ,func: * x-------------
				
				
				idx = ResolveCommand.ResolveCommand.GetPairIndex(func);
			}
		}
	}
}
