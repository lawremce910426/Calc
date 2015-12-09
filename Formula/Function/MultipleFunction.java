package Function;

import NumberCalculating.NumberCalculating;
import Value.Value;

public class MultipleFunction  {
	FunctionSymbolDetecter detector;
	String data; 
	public MultipleFunction(String data) throws Exception {
		detector = new FunctionSymbolDetecter();
		if(detector.DetectSymbols(data) == 1)throw new Exception("only one symbol");
		this.data = data;
	}
	public Value PutIn(Value value[]) throws Exception
	{
		char key[] = detector.GetSymbols(data);
		for(int i = 0;i != key.length;i++)
			data = data.replace(String.valueOf(key[i]), value[i].toString());
		NumberCalculating calculator = new NumberCalculating();
		return calculator.GetResult(data);
	}
}
