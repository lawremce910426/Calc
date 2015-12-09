package Function;

import NumberCalculating.NumberCalculating;
import Value.Value;

class SingleFunction{
	String formula;
	FunctionSymbolDetecter detector;
	public SingleFunction(String data) throws Exception
	{
		detector = new FunctionSymbolDetecter();
		if(detector.DetectSymbols(data) != 1)throw new Exception("Multi symbols");
		formula = data;
	}
	public Value PutIn(Value x) throws Exception
	{
		formula = formula.replaceAll(detector.GetSymbol(formula) ,"(" + x.toString() + ")");
		NumberCalculating calculator = new NumberCalculating();
		return calculator.GetResult(formula);
	}
}
